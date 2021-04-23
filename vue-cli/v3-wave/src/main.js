import { createApp, h } from 'vue';
import App from './App.vue';
import WaveUI from 'wave-ui/src/wave-ui/core';
import router from './router';
import store from './store';

const app = createApp({
    render: () => h(App)
});

import { WApp, WButton } from 'wave-ui/src/wave-ui/components';

app.use(store);
app.use(router);
app.use(WaveUI, {
    components: {
        WApp,
        WButton
    }
});

new WaveUI(app,{
    //WaveUI options
});

app.mount('#app');