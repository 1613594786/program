package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.common.JudgeBedName;
import com.example.springboot.entity.AdjustRoom;
import com.example.springboot.entity.DormRoom;
import com.example.springboot.mapper.DormRoomMapper;
import com.example.springboot.service.DormRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.example.springboot.common.CalPeopleNum.calNum;


@Service
public class DormRoomImpl extends ServiceImpl<DormRoomMapper, DormRoom> implements DormRoomService {

    @Resource
    private DormRoomMapper dormRoomMapper;

    /**
     * 首页顶部：空宿舍统计
     */
    @Override
    public int notFullRoom() {
        QueryWrapper<DormRoom> qw = new QueryWrapper<>();
        qw.lt("current_capacity", 4);
        int notFullRoomNum = Math.toIntExact(dormRoomMapper.selectCount(qw));
        return notFullRoomNum;
    }

    /**
     * 添加房间
     */
    @Override
    public int addNewRoom(DormRoom dormRoom) {
        int insert = dormRoomMapper.insert(dormRoom);
        return insert;
    }

    /**
     * 查找房间
     */
    @Override
    public Page find(Integer pageNum, Integer pageSize, String search) {
        Page page = new Page<>(pageNum, pageSize);
        QueryWrapper<DormRoom> qw = new QueryWrapper<>();
        qw.like("Dormroom_id", search);
        Page roomPage = dormRoomMapper.selectPage(page, qw);
        return roomPage;
    }

    /**
     * 更新房间
     */
    @Override
    public int updateNewRoom(DormRoom dormRoom) {
        int i = dormRoomMapper.updateById(dormRoom);
        return i;
    }

    /**
     * 删除房间
     */
    @Override
    public int deleteRoom(Integer dormRoomId) {
        int i = dormRoomMapper.deleteById(dormRoomId);
        return i;
    }

    /**
     * 删除床位上的学生信息
     */
    @Override
    public int deleteBedInfo(String bedName, Integer dormRoomId, int calCurrentNum) {
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("dormroom_id", dormRoomId);
        updateWrapper.set(bedName, null);
        updateWrapper.set("current_capacity", calCurrentNum - 1);
        int update = dormRoomMapper.update(null, updateWrapper);
        return update;

    }

    /**
     * 床位信息，查询该学生是否已有床位
     */
    @Override
    public DormRoom judgeHadBed(String username) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("first_bed", username);
        qw.or();
        qw.eq("second_bed", username);
        qw.or();
        qw.eq("third_bed", username);
        qw.or();
        qw.eq("fourth_bed", username);
        DormRoom dormRoom = dormRoomMapper.selectOne(qw);
        return dormRoom;
    }

    /**
     * 主页 住宿人数
     */
    // TODO: 2024/9/13 修改逻辑 
    @Override
    public Long selectHaveRoomStuNum() {
        QueryWrapper<DormRoom> qw1 = new QueryWrapper<>();
        qw1.isNotNull("first_bed");
        Long first_bed = dormRoomMapper.selectCount(qw1);

        QueryWrapper<DormRoom> qw2 = new QueryWrapper<>();
        qw2.isNotNull("second_bed");
        Long second_bed = dormRoomMapper.selectCount(qw2);

        QueryWrapper<DormRoom> qw3 = new QueryWrapper<>();
        qw3.isNotNull("third_bed");
        Long third_bed = dormRoomMapper.selectCount(qw3);

        QueryWrapper<DormRoom> qw4 = new QueryWrapper<>();
        qw4.isNotNull("fourth_bed");
        Long fourth_bed = dormRoomMapper.selectCount(qw4);

        Long count = first_bed + second_bed + third_bed + fourth_bed;
        return count;
    }

    /**
     * 获取每栋宿舍学生总人数
     */
    @Override
    public Long getEachBuildingStuNum(int dormBuildId) {

        QueryWrapper<DormRoom> qw1 = new QueryWrapper<>();
        qw1.eq("dormbuild_id", dormBuildId);
        qw1.isNotNull("first_bed");
        Long first_bed = dormRoomMapper.selectCount(qw1);

        QueryWrapper<DormRoom> qw2 = new QueryWrapper<>();
        qw2.eq("dormbuild_id", dormBuildId);
        qw2.isNotNull("second_bed");
        Long second_bed = dormRoomMapper.selectCount(qw2);

        QueryWrapper<DormRoom> qw3 = new QueryWrapper<>();
        qw3.eq("dormbuild_id", dormBuildId);
        qw3.isNotNull("third_bed");
        Long third_bed = dormRoomMapper.selectCount(qw3);

        QueryWrapper<DormRoom> qw4 = new QueryWrapper<>();
        qw4.eq("dormbuild_id", dormBuildId);
        qw4.isNotNull("fourth_bed");
        Long fourth_bed = dormRoomMapper.selectCount(qw4);

        Long count = first_bed + second_bed + third_bed + fourth_bed;

        return count;
    }

    /**
     * 根据调宿申请表对房间表内的学生床位进行调整。
     * 此方法用于处理学生床位的调整，根据调宿申请表中的信息更新房间表。
     * @param adjustRoom 调宿申请表对象，包含调宿相关的信息。
     * @return 操作结果的状态码：
     *         - 1 表示床位调整成功
     *         - 0 表示没有数据被更新，可能是因为床位已被占用或不存在
     *         - -1 表示更新过程中发生错误
     *         - -2 表示当前床位不存在
     */
    @Override
    public int adjustRoomUpdate(AdjustRoom adjustRoom) {
        // 获取调宿人姓名
        String username = adjustRoom.getUsername();
        // 获取当前房间号
        int currentRoomId = adjustRoom.getCurrentRoomId();
        // 根据当前床位ID获取当前床位名称
        String currentBedName = JudgeBedName.getBedName(adjustRoom.getCurrentBedId());
        // 获取目标房间号
        int towardsRoomId = adjustRoom.getTowardsRoomId();
        // 根据目标床位ID获取目标床位名称
        String towardsBedName = JudgeBedName.getBedName(adjustRoom.getTowardsBedId());

        // 创建查询包装器，用于查询当前房间和床位
        QueryWrapper qw = new QueryWrapper();
        qw.eq("dormroom_id", currentRoomId); // 设置查询条件，当前房间ID
        qw.isNotNull(currentBedName); // 确保当前床位名称不为空

        // 执行查询，获取当前房间对象
        DormRoom dormRoom1 = dormRoomMapper.selectOne(qw);
        if (dormRoom1 == null) {
            // 如果当前房间不存在，返回-2
            return -2;
        }

        // 计算当前房间的床位容量
        int currentCapacity1 = calNum(dormRoom1);

        // 创建更新包装器，用于更新当前房间的床位和容量
        UpdateWrapper uw1 = new UpdateWrapper();
        uw1.eq("dormroom_id", currentRoomId); // 设置更新条件，当前房间ID
        uw1.set(currentBedName, null); // 将当前床位设置为null，表示床位已调整
        uw1.set("current_capacity", currentCapacity1 - 1); // 减少当前房间的床位容量

        // 执行更新操作，更新当前房间的床位和容量
        int result1 = dormRoomMapper.update(null, uw1);

        // 获取目标房间对象
        DormRoom dormRoom2 = dormRoomMapper.selectById(towardsRoomId);
        // 计算目标房间的床位容量
        int currentCapacity2 = calNum(dormRoom2);

        // 如果当前房间床位更新成功
        if (result1 == 1) {
            // 创建更新包装器，用于更新目标房间的床位和容量
            UpdateWrapper uw2 = new UpdateWrapper();
            uw2.eq("dormroom_id", towardsRoomId); // 设置更新条件，目标房间ID
            uw2.set(towardsBedName, username); // 将目标床位设置为调宿人姓名
            uw2.set("current_capacity", currentCapacity2 + 1); // 增加目标房间的床位容量

            // 执行更新操作，更新目标房间的床位和容量
            int result2 = dormRoomMapper.update(null, uw2);
            return result2; // 返回目标房间更新操作的结果
        }

        // 如果当前房间床位更新失败，返回-1
        return -1;
    }


    /**
     * 检查该房间是否满了
     */
    @Override
    public DormRoom checkRoomState(Integer dormRoomId) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("dormroom_id", dormRoomId);
        qw.lt("current_capacity", 4);
        DormRoom dormRoom = dormRoomMapper.selectOne(qw);
        return dormRoom;
    }

    /**
     * 检查该房间是否存在
     */
    @Override
    public DormRoom checkRoomExist(Integer dormRoomId) {
        DormRoom dormRoom = dormRoomMapper.selectById(dormRoomId);
        return dormRoom;
    }


    /**
     * 检查床位是否有人
     */
    @Override
    public DormRoom checkBedState(Integer dormRoomId, int bedNum) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq("dormroom_id", dormRoomId);
        qw.isNull(JudgeBedName.getBedName(bedNum));
        DormRoom dormRoom = dormRoomMapper.selectOne(qw);
        return dormRoom;
    }


}
