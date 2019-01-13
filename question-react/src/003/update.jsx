import React, {Component} from 'react';

class App extends Component {

	state = {
		list: [1, 2, 3]
	};

	render() {
		const {list} = this.state;
		return (
			<div>
				<button onClick={this.handleDelete}>Delete</button>
				<ul>{list.map(n => <li key={n}>{n}</li>)}</ul>
			</div>
		);
	}

	handleDelete = () => {
		this.state.list.pop();
		this.setState((prevState) => ({list: prevState.list}));
	};

	handleDelete2 = () => {
		this.setState((prevState) => (list: [...prevState.list].pop()));
	}
}