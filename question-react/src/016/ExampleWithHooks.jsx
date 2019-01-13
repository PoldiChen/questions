import React from "react";
import { useState, useEffect } from "react";

function ExampleWithHooks() {

    const [count, setCount] = useState(0);

    useEffect(()=>{
        document.title = `react hook ${count}`;
    });

    return (
        <div>
            <p>you click {count} times.</p>
            <button onClick={() => setCount(count+1)}>click</button>
        </div>
    );
}

export default ExampleWithHooks;
