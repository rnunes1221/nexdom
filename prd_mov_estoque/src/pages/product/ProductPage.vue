<template>
  <div>
    <TableProduct />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import TableProduct from 'src/components/product/tables/TableProduct.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    TableProduct
  }
})
</script>
