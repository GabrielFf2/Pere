
import { setupCounter } from './counter.js'
import './asets/css/bootstrap-5.3.3/scss/bootstrap.scss'

document.querySelector('#app').innerHTML = `
  <div>
   
    <h1 class="text-bg-primary">Hello, world!</h1>
    
  </div>
`

setupCounter(document.querySelector('#counter'))
