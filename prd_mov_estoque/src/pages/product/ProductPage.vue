<template>
  <div class="q-gutter-md">
    <TableProduct />

    <TableProductByType />

    <TableProfitByProduct />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import TableProduct from 'src/components/product/tables/TableProduct.vue';
import TableProductByType from 'src/components/product/tables/TableProductByType.vue';
import TableProfitByProduct from 'src/components/product/tables/TableProfitByProduct.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    TableProduct,
    TableProductByType,
    TableProfitByProduct
  }
})
</script>
