<template>
  <div class="container-card">
    <div class="card">
      <img :src="cMeal.strMealThumb" :alt="cMeal.strMeal" />
      <div class="card-details">
        <div><span>Nome: </span>{{ cMeal.strMeal }}</div>
        <div><span>Categoria: </span>{{ cMeal.strCategory }}</div>
        <div><span>Área: </span>{{ cMeal.strArea }}</div>
      </div>
    </div>
    <div class="card-instruction">
      <div>{{ cMeal.strInstructions }}</div>
    </div>
  </div>
</template>
<script>
export default {
  name: "card-meals",
  props: {
    meal: Object,
  },
  computed: {
    cMeal() {
      if (this.meal) {
        return this.meal;
      }
      return "";
    },
  },
};
</script>
<style lang="scss" scoped>
.container-card {
  padding: 15px;
  margin-bottom: 15px;
  border-radius: 7px;
  background-color: #fff;
}
.card {
  display: flex;
  max-height: auto;
  margin-bottom: 15px;
  background-color: #d9d9d9;
  border-radius: 7px;
  &-details,
  &-instructions {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 5px;
    span {
      font-weight: bold;
      font-size: 1.5rem;
    }
  }
  img {
    max-width: 120px;
    max-height: 120px;
  }
}
</style>
