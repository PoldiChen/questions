import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Example from "./016/Example";
import ExampleWithHooks from "./016/ExampleWithHooks";

class App extends Component {
    render() {
        return (
            <div>
                <Example />
                <ExampleWithHooks />
            </div>
        );
    }
}

export default App;
