import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import HarvestView from '../views/HarvestView.vue'
import ExpirationView from '../views/ExpirationView.vue'
import TransplantView from '../views/TransplantView.vue'
import FormView from '../views/FormView.vue'
import CropPlanView from '../views/CropPlanView.vue'
import SalesChartView from '../views/SalesChartView.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/harvest",
      name: "harvestview",
      component: HarvestView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/expiration",
      name: "expirationview",
      component: ExpirationView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/transplant",
      name: "transplantview",
      component: TransplantView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/form",
      name: "formview",
      component: FormView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/cropplan",
      name: "cropplanview",
      component: CropPlanView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/sale',
      name: "salesview",
      component: SalesChartView,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
