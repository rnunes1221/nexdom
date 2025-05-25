<template>
  <q-dialog v-model="modelValue">
    <q-card>
      <q-card-section>
        <div class="text-h6">Are you sure you want to delete?</div>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn flat label="Cancel" v-close-popup />
        <q-btn flat label="Confirm" color="negative" @click="confirmDelete(this.idProduct)" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
<script>
import { defineComponent } from 'vue';

export default defineComponent({
  props: {
    modelValue: Boolean,
    idProduct: Number
  },

  emits: ['update:modelValue'],

  methods: {
    confirmDelete(idProduct) {
      this.$emit('update:modelValue', false)
      this.$api.delete(`products/${idProduct}`)
      .then((res) => {
        if (res.status === 200) {
           this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "Product Deleted",
            type: "positive",
          });
          setTimeout(() => {
            location.reload()
          }, 2000)
        }
        else {
          this.$q.notify({
            closeBtn: true,
            timeout: 3000,
            message: "Error.",
            type: "negative",
          });
        }
      })
      .catch((error) => {
        this.$q.notify({
          closeBtn: true,
          timeout: 3000,
          message: `Error: ${error.message}`,
          type: "negative",
        });
      });
    }
  }
})
</script>
