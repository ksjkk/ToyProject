import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// primevue
import PrimeVue from 'primevue/config'
import Button from 'primevue/button'
import Toast from 'primevue/toast';
import ToastService from 'primevue/toastservice'
import MegaMenu from 'primevue/megamenu'

// css
import 'primevue/resources/themes/saga-blue/theme.css'  //theme
import 'primevue/resources/primevue.min.css'            //core css
import 'primeicons/primeicons.css'                      //icons

const app = createApp(App);

app.use(store);
app.use(router);

app.use(PrimeVue);
app.use(ToastService);

app.component('Button', Button);
app.component('Toast', Toast);
app.component('MegaMenu', MegaMenu);

app.mount('#app');
