<template>
  <span style="font-size: 22px;display: block;margin-bottom: 30px;margin-left: 10px;">宿舍通告</span>
  <el-timeline>
    <el-timeline-item v-for="(activity, index) in activities.slice(0, 8)" :key="index"
                      :timestamp="activity.releaseTime">
      <span @click="viewDetail(activity)" style="font-size: 15px">{{ activity.title }}</span><br/>
    </el-timeline-item>
  </el-timeline>

  <el-dialog v-model="centerDialogVisible" :title=current_activity.title width="500" center>
    <span style="font-size: 10px; display:flex; justify-content: center">发布人:{{current_activity.author}}</span>
    <span style="font-size: 10px; display:flex; justify-content: center">发布时间: {{current_activity.releaseTime}}</span><br/>
    <span>{{current_activity.content}}</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button type="primary" @click="centerDialogVisible = false">确定</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<script>
import { ref } from 'vue'

export default {
  name: 'Notice',
  setup() {
    return {
      centerDialogVisible: ref(false),
      current_activity: ref({}),
    }
  },
  props: {
    activities: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    viewDetail(activity) {
      this.centerDialogVisible = true;
      this.current_activity = activity;
    }
  }
}

</script>
