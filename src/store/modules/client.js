import { clientLogin, clientLogout, getClientInfo } from '@/api/client/auth'
import { getClientToken, setClientToken, removeClientToken } from '@/utils/clientAuth'

const client = {
  namespaced: true,

  state: {
    token: getClientToken(),
    name: '',
    avatar: '',
    roles: [],
    permissions: []
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    },
    SET_AVATAR: (state, avatar) => {
      state.avatar = avatar
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_PERMISSIONS: (state, permissions) => {
      state.permissions = permissions
    }
  },

  actions: {
    // 登录
    Login({ commit }, userInfo) {
      const account = userInfo.account.trim()
      const password = userInfo.password
      return new Promise((resolve, reject) => {
        clientLogin({ account, password }).then(res => {
          setClientToken(res.token)
          commit('SET_TOKEN', res.token)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo({ commit }) {
      return new Promise((resolve, reject) => {
        getClientInfo().then(res => {
          const user = res.user

          // 验证返回的roles是否是一个非空数组
          if (res.roles && res.roles.length > 0) {
            commit('SET_ROLES', res.roles)
            commit('SET_PERMISSIONS', res.permissions)
          } else {
            commit('SET_ROLES', ['ROLE_DEFAULT'])
          }

          commit('SET_NAME', user.userName)
          commit('SET_AVATAR', user.avatar)
          resolve(res)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 退出系统
    LogOut({ commit }) {
      return new Promise((resolve, reject) => {
        clientLogout().then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          commit('SET_PERMISSIONS', [])
          removeClientToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    }
  }
}

export default client