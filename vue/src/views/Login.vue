
<template>
  <div id="login" class="text-center">
    <div class="imgcontainer">
 <!--     <img src="@/assets/logo3.png" class="img"> -->
        Farm Assist
    </div>
    <div class="form-container">
    <form class="form-signin" @submit.prevent="login">
    <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /><br>
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /><br><button type="submit">Sign in</button><br><br>
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
  
    </form>
    </div>
  </div>
</template>

<script>
import authService from "../services/AuthService";


export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>




<style>
@import url("https://fonts.googleapis.com/css2?family=Bungee");


div > #nav{
  display: flex;
  justify-content: center;
}


body {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("../assets/farm.jpg");
  background-color: white;
  background-size: cover;
  }

form {
  border: 3px solid #f1f1f1;
  padding: 20px;
  }

.form-signin {
  background-color: white;   
  opacity: 0.9; 
}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: rgb(63, 104, 64);
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

h1 {
  color: rgb(51, 49, 49);
  font-size: 20px; 
}

.sr-only {
  color:rgb(51, 49, 49)
}

.form-container {
  align-self: center;
  padding-top: 50px;
  padding-left: 300px;
  padding-right: 300px;
}

.h3 {
  margin-top: 0px;
  font-size: 20px;
  font-family: Arial, Helvetica, sans-serif;
}

.imgcontainer {
  font-family: 'Bungee', Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  font-size: 100px;
  color:rgb(63, 60, 60)
}

</style>
