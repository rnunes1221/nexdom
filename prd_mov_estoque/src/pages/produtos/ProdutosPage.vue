<template>
  <div>
    <TableProdutos />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import TableProdutos from 'src/components/produto/tables/TableProdutos.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    TableProdutos
  }
})
</script>
