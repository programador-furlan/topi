<template>
  <DefaultLayout>
    <div class="container-home">
      <template v-if="open">
        <ModalCreate @close="open = $event" />
      </template>
      <div class="search">
        <input type="text" placeholder="faça sua busca" v-model="search" />
        <div>
          <select class="origin" v-model="origin">
            <option value="" selected disabled>
              Escolha uma origem de dados
            </option>
            <option value="local">local</option>
            <option value="example" selected>exemplo</option>
          </select>
        </div>
        <div class="add" @click="open = true">+</div>
      </div>
      <div class="container-meals">
        <template v-if="cMeals.length > 0">
          <template v-for="item in cMeals">
            <Card :key="item.id" :meal="item" />
          </template>
        </template>
      </div>
    </div>
  </DefaultLayout>
</template>

<script>
// @ is an alias to /src
import DefaultLayout from "@/components/defaultLayout.vue";
import Card from "@/components/card.vue";
import ModalCreate from "@/components/modalCreate.vue";
const axios = require("axios");

export default {
  name: "Home",
  data() {
    return {
      origin: "",
      open: false,
      search: "",
      mealsExample: [],
    };
  },
  mounted() {
    this.getExampleTask();
  },
  watch: {
    origin() {
      if (this.origin === 'local') {
        this.getMeals()
      }
      if (this.origin === 'example') {
        this.getExampleTask()
      }
    }
  },
  computed: {
    cMeals() {
      if (this.search !== "") {
        return this.mealsExample.filter((area) =>
          area.strMeal.toLowerCase().includes(this.search.toLowerCase())
        );
      }
      return this.mealsExample;
    },
  },
  methods: {
    async getMeals() {
      const headers = {
        contentType: "application/json",
        accept: "application/json",
        accessControlAllowOrigin: "*",
        accessControlAllowCredentials: "*",
      };
      axios.get("http://localhost:8080/meals", headers).then((response) => {
        this.mealsExample = response.data;
      });
    },
    async getExampleTask() {
      axios
        .get(
          `https://www.themealdb.com/api/json/v1/1/search.php?s=${this.search}`
        )
        .then((response) => {
          this.mealsExample = response.data.meals;
        });
    },
  },
  components: {
    DefaultLayout,
    Card,
    ModalCreate,
  },
};
</script>
<style lang="scss" scoped>
.container-home {
  // background-color: #fff;
  .search {
    display: flex;
    align-items: center;
    justify-content: space-between;
    box-shadow: 1px 1px 5px 1px black;
    border-radius: 7px;
    padding: 15px;
    background-color: #d9d9d9;

    .add {
      cursor: pointer;
      padding: 8px 12px;
      border-radius: 7px;
      background-color: #009933;
      color: white;
    }
    input {
      height: 38px;
      padding: 5px;
      outline: none;
      border: none;
      border-radius: 7px;
    }
    select {
      height: 38px;
      padding: 5px;
      outline: none;
      border: none;
      border-radius: 7px;
    }
  }
  .container-meals {
    box-shadow: 1px 1px 5px 1px black;
    border-radius: 7px;
    margin-top: 15px;
    padding: 15px;
    height: 500px;
    overflow-y: scroll;
  }
}
</style>
