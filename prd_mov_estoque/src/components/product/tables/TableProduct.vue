<template>
  <div class="q-pa-md">
    <q-table
      title="Products"
      :rows="rows"
      :columns="columns"
      row-key="name"
    >
      <template v-slot:top-left>
        <q-btn
          label="Product"
          icon="add"
          color="primary"
          dense
          @click="redirectCreateProductPage()"
        />
      </template>

      <template v-slot:body="props">
        <q-tr :props="props">
          <q-td key="id" :props="props">
            {{ props.row.id }}
          </q-td>

          <q-td key="description" :props="props">
            {{ props.row.description }}
          </q-td>

          <q-td key="type" :props="props">
            {{ props.row.type }}
          </q-td>

          <q-td key="supplierValue" :props="props" class="text-green">
            R$ {{ parseFloat(props.row.supplierValue).toFixed(2) }}
          </q-td>

          <q-td key="stock" :props="props">
            {{ props.row.stock }}
          </q-td>

          <q-td key="operations" :props="props">
             <q-btn
              icon="reorder"
              round
              dense
              size="11px"
              color="primary"
              @click="redirectCreateMovementPage(props.row)"
            >
              <q-tooltip>
                Create Movement
              </q-tooltip>
            </q-btn>
            <q-btn
              icon="edit"
              round
              dense
              size="11px"
              color="primary"
              class="q-ml-sm"
              @click="redirectUpdateProductPage(props.row.id)"
            >
              <q-tooltip>
                Update
              </q-tooltip>
            </q-btn>

            <q-btn
              icon="delete"
              round
              dense
              size="11px"
              color="negative"
              class="q-ml-sm"
              @click="deleteProduct(props.row.id)"
            >
              <q-tooltip>
                Excluir
              </q-tooltip>
            </q-btn>
          </q-td>
        </q-tr>
      </template>
    </q-table>
  </div>
  <DialogConfirmDelete v-model="confirmDelete" :idProduct="idProduct"/>

</template>
<script>
import { defineComponent } from 'vue';
import DialogConfirmDelete from '../dialog/DialogConfirmDelete.vue';
export default defineComponent({
  data(){
    return {
      confirmDelete: false,
      idProduct: null,
      columns:[
        { name: 'id', label: 'Id', field: 'id', align: 'left', sortable: true },
        { name: 'description', label: 'Description', field: 'description', align: 'left', sortable: true },
        { name: 'type', label: 'Type', field: 'type', align: 'left', sortable: true },
        { name: 'supplierValue', label: 'Supplier Value', field: 'supplierValue', align: 'left', sortable: true },
        { name: 'stock', label: 'Stock', field: 'stock', align: 'left', sortable: true },
        { name: 'operations', label: 'Operations', field: 'operations', align: 'left'},
      ],
      rows: []
    }
  },
  components:{
    DialogConfirmDelete
  },
  methods:{
    deleteProduct(idProduct){
      this.idProduct = idProduct;
      this.confirmDelete = true;
    },

    redirectCreateProductPage(){
      this.$router.push({ path: 'createProduct'});
    },

    redirectUpdateProductPage(product){
      this.$router.push({
        path: 'updateproduct',
        query: { product: JSON.stringify(product) }
      });
    },

    redirectCreateMovementPage(product){
      this.$router.push({
        path: 'createmovement',
        query: { product: JSON.stringify(product) }
      });
    },

    getAllProducts(){
      this.$api.get(`products`)
      .then((res) => {
        if (res.status === 200) {
          this.rows = res.data;

          if (res.data.length === 0) {
            this.$q.notify({
              closeBtn: true,
              timeout: 3000,
              message: "Products not found.",
              type: "warning",
            });
          }
        } else {
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
  },
  components:{
    DialogConfirmDelete
  },
  created(){
    this.getAllProducts();
  }

})
</script>
