<template>
  <div>
    <CardEditarProdutos />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardEditarProdutos from 'src/components/produto/cards/CardEditarProdutos.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardEditarProdutos
  }
})
</script>
