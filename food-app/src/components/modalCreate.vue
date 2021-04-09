<template>
  <div class="container-create">
    <div class="form-create">
      <div class="close" @click="close()">x</div>
      <input type="text" v-model="strMeal" placeholder="Nome da comida" />
      <input type="text" v-model="strArea" placeholder="categoria da comida" />
      <input type="text" v-model="strCategory" placeholder="Área da comida" />
      <input
        type="text"
        v-model="strMealThumb"
        placeholder="Url da imagem da comida"
      />
      <textarea
        v-model="strInstructions"
        placeholder="Instruções de preparo"
      ></textarea>
      <button @click="add()">salvar</button>
    </div>
  </div>
</template>
<script>
const axios = require("axios");

export default {
  name: "modal-create",
  data() {
    return {
      strMeal: "",
      strArea: "",
      strCategory: "",
      strMealThumb: "",
      strInstructions: "",
      resp: "",
    };
  },
  methods: {
    close() {
      this.$emit("close", false);
    },
    add() {
      const headers = {
        contentType: "application/json",
        accept: "application/json",
        accessControlAllowOrigin: "*",
        accessControlAllowCredentials: "*",
      };
      const body = {
        strMeal: this.strMeal,
        strArea: this.strArea,
        strCategory: this.strCategory,
        strMealThumb: this.strMealThumb,
        strInstructions: this.strInstructions,
      };
      axios
        .post("http://localhost:8080/meals", body, headers)
        .then((response) => {
          console.log(response.data)
        });
    },
  },
};
</script>
<style lang="scss" scoped>
.container-create {
  position: fixed;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: 100vh;
  top: 0;
  left: 0;
  background-color: rgba(0, 0, 0, 0.9);
  .form-create {
    position: relative;
    display: flex;
    flex-direction: column;
    background-color: white;
    padding: 15px;
    border-radius: 7px;
    width: 50vw;
    input {
      background-color: #d9d9d9;
      padding: 0 5px;
      height: 38px;
      margin-bottom: 10px;
      outline: none;
      border: none;
      border-radius: 7px;

    }
    textarea {
      background-color: #d9d9d9;
      padding: 5px;
      height: 100px;
      outline: none;
      border: none;
      border-radius: 7px;
    }
    .close {
      cursor: pointer;
      position: absolute;
      right: -20px;
      top: -20px;
      background-color: black;
      padding: 10px 15px;
      border-radius: 50%;
      color: white;
    }
    button {
      background-color: #009933;
      margin-top: 10px;
      color: white;
      padding: 10px 0;
      border-radius: 7px;
      outline: none;
      border: none;
      cursor: pointer;
    }
  }
}
</style>
