const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('src/pages/product/ProductPage.vue') },
      { path: 'createProduct', component: () => import('src/pages/product/CreateProductPage.vue') },
      { path: 'updateProduct', component: () => import('src/pages/product/UpdateProductPage.vue') },
      { path: 'movement', component: () => import('src/pages/movement/MovementPage.vue') },
      { path: 'createMovement', component: () => import('src/pages/movement/CreateMovementPage.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
