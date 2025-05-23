<template>
  <div>
    <CardCreateProduct />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardCreateProduct from 'src/components/product/cards/CardCreateProduct.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardCreateProduct
  }
})
</script>
