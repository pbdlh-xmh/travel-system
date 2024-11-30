import Vue from 'vue'
import Cookies from 'js-cookie'
import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import '@/assets/styles/index.scss' // global css
import '@/assets/styles/ruoyi.scss' // ruoyi css
import App from './App'
import store from './store'
import router from './router'  // 这里导入的是后台路由
import directive from './directive'
import plugins from './plugins'
import { download } from '@/utils/request'

import './assets/icons'
import './permission'  // 使用后台的权限控制
import { getDicts } from "@/api/system/dict/data"
import { getConfigKey } from "@/api/system/config"
import { parseTime, resetForm, addDateRange, selectDictLabel, selectDictLabels, handleTree } from "@/utils/ruoyi"

// 组件导入...（保持不变）
import Pagination from "@/components/Pagination"
import RightToolbar from "@/components/RightToolbar"
import Editor from "@/components/Editor"
import FileUpload from "@/components/FileUpload"
import ImageUpload from "@/components/ImageUpload"
import ImagePreview from "@/components/ImagePreview"
import DictTag from '@/components/DictTag'
import VueMeta from 'vue-meta'
import DictData from '@/components/DictData'

// 全局方法挂载（保持不变）
Vue.prototype.getDicts = getDicts
Vue.prototype.getConfigKey = getConfigKey
Vue.prototype.parseTime = parseTime
Vue.prototype.resetForm = resetForm
Vue.prototype.addDateRange = addDateRange
Vue.prototype.selectDictLabel = selectDictLabel
Vue.prototype.selectDictLabels = selectDictLabels
Vue.prototype.download = download
Vue.prototype.handleTree = handleTree

// 全局组件挂载（保持不变）
Vue.component('DictTag', DictTag)
Vue.component('Pagination', Pagination)
Vue.component('RightToolbar', RightToolbar)
Vue.component('Editor', Editor)
Vue.component('FileUpload', FileUpload)
Vue.component('ImageUpload', ImageUpload)
Vue.component('ImagePreview', ImagePreview)

Vue.use(directive)
Vue.use(plugins)
Vue.use(VueMeta)
DictData.install()

// 使用 Element UI
Vue.use(Element, {
  size: Cookies.get('size') || 'medium'
})

Vue.config.productionTip = false

// 创建后台管理系统的 Vue 实例
new Vue({
  el: '#app',
  router,  // 使用后台路由
  store,
  render: h => h(App)
})