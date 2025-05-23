<template>
  <div>
    <CardUpdateProduct />
  </div>
</template>

<script>
import { defineComponent } from 'vue';
import CardUpdateProduct from 'src/components/product/cards/CardUpdateProduct.vue';
export default defineComponent({
  data(){
    return {
    }
  },
  components:{
    CardUpdateProduct
  }
})
</script>
