
function checkShouldComponentUpdate(workInProgress, oldProps, newProps, oldState, newState, newContext) {
	const ctor = workInProgress.type;
	if (typeof instance.shouldComponentUpdate === 'function') {
		startPhaseTimer(workInProgress, 'shouldComponentUpdate');
		const shouldUpdate = instance.shouldComponentUpdate(newProps, newState, newContext);
		stopPhaseTimer();
		return shouldUpdate;
	}
	if (ctor.prototype && ctor.prototype.isPureReactComponent) {
		return(!shallowEqual(oldProps, newProps) || !shallowEqual(oldState, newState));
	}
	return true;
}