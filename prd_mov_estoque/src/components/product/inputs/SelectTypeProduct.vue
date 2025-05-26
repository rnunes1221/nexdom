<template>
  <q-select
    :options="typeProduct"
    filled
    dense
    stack-label
    label="Type Product"
  />
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  data(){
    return {
      typeProduct: ['ELECTRONIC', 'HOME', 'FURNITURE']
    }
  },

})
</script>
