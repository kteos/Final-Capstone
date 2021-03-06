import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import VuePapaParse from 'vue-papa-parse'
import VueSidebarMenu from 'vue-sidebar-menu'
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'
import Chartkick from 'vue-chartkick'
import Chart from 'chart.js'

Vue.use(Vuex)
Vue.use(VuePapaParse)
Vue.use(VueSidebarMenu)
Vue.use(Chartkick.use(Chart))


/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));


if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    harvest: [],
    harvests: [],
    expiration: [],
    expirations: [],
    transplant: [],
    transplants: [],
    newSale: {},
    newHarvestInfo: {},
    newWasteInfo: {},
    newLossInfo: {},
    crop: [],
    crops: []
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    POST_HARVESTS(state, harvest) {
      state.harvest = harvest;
    },
    SET_HARVESTS(state, data){
      state.harvests = data;
    },
    POST_EXPIRATIONS(state, expiration) {
      state.expiration = expiration;
    },
    SET_EXPIRATIONS(state, data){
      state.expirations = data;
    },
    POST_TRANSPLANTS(state, transplant) {
      state.transplant = transplant;
    },
    SET_TRANSPLANTS(state, data) {
      state.transplants = data;
    },
    ADD_INFO(state,data){
      state.newInfo = data;
    },
    ADD_HARVEST_INFO(state,data){
      state.newHarvestInfo = data;
    },
    ADD_WASTE_INFO(state,data){
      state.newWasteInfo = data;
    },
    ADD_LOSS_INFO(state,data){
      state.newLossInfo = data;
    },
    POST_CROPS(state, crop) {
      state.crop = crop;
    },
    SET_CROPS(state,data){
      state.crops = data;
    }
  }
})
