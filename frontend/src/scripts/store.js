import Vuex from 'vuex'

const store = new Vuex.Store({
    state: {
        account: {
            id: 0
        }
    },
    mutations: {
        setAccount(state, payload){
            state.account.id = payload;
        }
    }
  })

  export default store;