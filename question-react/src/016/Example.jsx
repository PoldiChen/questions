import React  from "react";

class Example extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            count: 0
        }
    }

    render() {
        return (
            <div>
                <p>you click {this.state.count} times.</p>
                <button onClick={() => {
                    this.setState({
                        count: this.state.count+1
                    });
                }}>Click</button>
            </div>
        );
    }
}

export default Example;