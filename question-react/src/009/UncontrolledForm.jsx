import React, { Component } from "react";

class UncontrolledForm extends Component {

    handleSubmit = () => {
        console.log(this.input.value); // 使用refs操作元素，直接获取value
    };

    render() {
        return (
            <form>
                <input
                    type='text'
                    ref={(input) => this.input = input}
                />
            </form>
        );
    }
}

export default UncontrolledForm;