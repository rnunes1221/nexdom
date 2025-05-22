<template>
  <div>
    <CardAdicionarProdutos />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardAdicionarProdutos from 'src/components/produto/cards/CardAdicionarProdutos.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardAdicionarProdutos
  }
})
</script>
