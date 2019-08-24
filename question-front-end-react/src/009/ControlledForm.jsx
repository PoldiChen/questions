import React, { Component } from 'react';


class ControlledForm extends Component {

	state = {
		username: ''
	};

	updateUserName = (e) => {
		this.setState({
			username: e.target.value
		});
	};

	handleSubmit = () => {};

	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<input
					type='text'
					value={this.state.username}
					onChange={this.updateUserName}
				/>
			</form>
		);
	}
}

export default ControlledForm;


