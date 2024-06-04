import logo from './components/img/logo.svg';
import './App.css';
import AppFAQ from './components/faq';
import { Sparkle } from './components/sparkles.js';



function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className='Sparkles1'>
            <Sparkle/>
        </div>
          <div className='hero'>
            <img src={logo} className="App-logo" alt="logo" />
            <p>
              Coming Fall 2024...
            </p>
          </div>
          


        <AppFAQ/>
        <div className='Sponsor'>
          <h2 className='SPONSORTITLE'>Sponsor</h2>
          <p className='sponsormessage'>If you would like to sponsor CodeRED Astra, please reach out to
          <a href='codered-corporate-relations@uhcode.red'> codered-corporate-relations@uhcode.red</a></p>
        </div>
      </header>
    </div>
  );
}

export default App;
