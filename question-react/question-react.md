

#### 1. React的三项核心技术？
响应式UI、虚拟DOM、组件

#### 2. React容器组件和展示组件？
容器组件管理数据、状态和业务逻辑<br>
展示组件只负责接收props展示UI

#### 3. Component和PureComponent？code
&emsp;&emsp;一个父组件下有多个子组件时，修改一个子组件会导致所有子组件重新渲染，可以用shouldComponentUpdate去判断，但这个及其消耗性能，不推荐。<br>
&emsp;&emsp;PureComponent在最外层默认实现了一个浅比较，简单的模拟shouldComponentUpdate方法。<br>
&emsp;&emsp;判断组件是否该更新时，如果typeof instance.shouldComponentUpdate === ‘function’，说明是一个继承自Component的组件，直接执行shouldComponentUpdate。<br>
&emsp;&emsp;如果ctor.prototype.isReactPureComponent，那就是一个继承自PureComponent的组件，React会将newProps和oldProps，newState和oldState分别做一层浅比较，只要有一个浅比较不相等，则返回true。<br>
&emsp;&emsp;shallowEqual先用Object.is判断是否相等，如果不等，再做引用类型的比较，比较属性key的长度，比较属性key的一一对应，比较属性value的引用。<br>
&emsp;&emsp;只做一层比较，所以叫浅比较。不递归比较是因为递归耗费性能，PureComponent只是做适度的优化。

#### 4. 新版本的生命周期函数？
##### 旧版本：
##### 挂载
constructor<br>
componentWillMount<br>
render<br>
componentDidMount
##### 更新
componentWillReceiveProps<br>
shouldComponentUpdate<br>
componentWillUpdate<br>
render<br>
componentDidUpdate
##### 卸载
componentWillUnmount

##### 新版本：
##### 挂载
constructor<br>
getDerivedStateFromProps<br>
render<br>
componentDidMount
##### 更新
getDerivedStateFromProps<br>
shouldComponentUpdate<br>
render<br>
componentDidUpdate
##### 卸载
componentWillUnmount

&emsp;&emsp;废弃的三个生命周期函数：componentWillMount、componentWillReceiveProps、componentWillUpdate<br>
&emsp;&emsp;两个新的函数：static getDerivedStateFromProps、getSnapshotBeforeUpdate<br>
&emsp;&emsp;构造函数一般做两件事：初始化state对象、给自定义方法绑定this。第一行应该执行super(props)，否则无法在构造函数中拿到this对象。<br>
&emsp;&emsp;getDerivedStateFromProps是一个静态方法，不能在函数里使用this，有两个参数，props和state，分别指接收到的新参数和当前的state对象，返回一个对象用来更新当前的state对象，如果不需要更新可返回null。这个函数会在组件挂载时接收到新的props，调用setState和forceUpdate的时候被调用。<br>
&emsp;&emsp;getSnapshotBeforeUpdate方法在render之后、componentDidUpdate之前调用，有两个参数prevProps和prevState，这个函数有一个返回值，作为第三个参数传给componentDidUpdate。这个函数一定要和componentDidUpdate一起使用，否则会有警告。

#### 5. 高阶组件是什么？如何实现一个高阶组件？
高阶组件是一个函数，接收一个组件，返回一个组件。<br>
因为返回的是一个组件，所以这个函数也可以看做是组件。<br>

实现的方式有两种：<br>
属性代理：高阶组件通过被包裹的React组件来操作props。？？？<br>
反向继承：高阶组件继承于被包裹的React组件。

#### 6. React推荐给组件定义key的原因？
React diff算法的三个策略：<br>
(1) Web UI中DOM节点跨层级的移动操作特别少，可以忽略不计<br>
(2) 拥有相同类的两个组件将会生成相似的树形结构，拥有不同类的两个组件将会生成不同的树形结构<br>
(3) 对于同一层级的一组节点，可以通过唯一的ID来区分<br>
对于策略(3)，处于同一层级的节点，操作有插入、移动、删除，如果给组件定义的唯一的key，在组件只是发生了位置变化时，可以只通过移动操作来更新，不需要创建、删除，大大提高了性能。

#### 7. React中Element和Component的区别？
Element是描述屏幕上所见内容的数据结构，是对UI的对象表述。典型的Element是利用JSX构建的声明式代码然后被转化为createElement的调用组合。<br>
Component是可以接收参数输入并返回某个Element的类或函数。

#### 8. 什么情况下用Class Component而不是Functional Component？
组件需要包含内部状态或者使用生命周期函数的时候。

#### 9. 受控组件Controlled Component和非受控组件Uncontrolled Component的区别？code
&emsp;&emsp;React的核心组成之一就是能够维护内部状态的自治组件，在引入原生的HTML表单元素（input，select，textarea等）时，是将所有数据都托管到React组件中，还是保留在DOM中，就是受控组件和非受控组件的区别。<br>
&emsp;&emsp;非受控组件看起来更好实现，可以直接从DOM获取数据，但并不提倡，因为实际情况下需要考虑表单验证，将数据托管到React组件有助于以声明式的方式完成，引入React或其他MVVM框架就是为了减少DOM的操作。

#### 10. 如何声明React应该编译的生产环境版本？
使用webpack的DefinePlugin方法将NODE_ENV的值置为production，编译版本中React会忽略propType验证以及其他警告信息，同时还会降低。。。<br>
《React 常用面试题目与分析.pdf》

#### 11. React中的事件处理逻辑？
&emsp;&emsp;为了解决跨浏览器兼容性问题，React将浏览器原生事件（Browser Native Event）封装成合成事件（SyntheticEvent）传入设置的事件处理器中，合成事件提供了和原生事件一样的接口，但屏蔽了浏览器底层的细节差异，保证了行为的一致性。<br>
&emsp;&emsp;另外，React并没有将事件附着到子元素上，而是以单一事件监听器的方式将所有事件发送到顶层进行处理，这样在更新DOM的时候不需要去考虑附着在子元素上的事件监听器，提高了性能。<br>

#### 12. 传入setState的第二个参数的作用是什么？
setState是异步的，完成后回调，在setState调用完成并且组件开始重新渲染的时候被调用。<br>
可以用来监听渲染是否完成？？<br>
《React 常用面试题目与分析.pdf》

#### 13. React性能优化方案？
重写shouldComponentUpdate避免不必要的dom操作<br>
使用production版本的react.js<br>
使用key帮助React识别列表中所有子组件的最小变化

#### 14. 虚拟DOM和浏览器DOM（browser dom）？
&emsp;&emsp;虚拟DOM是React的核心，本质是JavaScript对象，browser dom是browser对象，是页面真实的dom。<br>
&emsp;&emsp;直接操作DOM会带来重绘、回流等问题，巨大的性能损耗导致渲染慢。React使用虚拟DOM，在状态更新时比较虚拟DOM的差异，更改变化的内容，最后统一由React去修改真实DOM，完成页面的更新、渲染。<br>

#### 15. 什么是SSR？
Server Slide Rendering，服务端渲染，一般用在单页应用SPA中。<br>
SSR的好处：<br>
(1) 更好的SEO（Search Engine Optimization，搜索引擎优化）<br>
React的原理是客户端渲染，在index.html写SEO不起作用。通过浏览器去加载js、cas有时间的延迟，所以搜索引擎会搜不到。<br>
(2) 解决白屏渲染<br>
SSR通过服务端请求数据，在内网中更加的加载所有js文件，把渲染后的页面返回给客户端。

#### 16.什么是React Hooks？code
&emsp;&emsp;React 16.7版本的新特性，Hooks是React函数组件内的一类特殊函数，通常以use开头，比如useState，使开发者能够在function component里依旧使用state和life-cycles，以及使用custom hook复用业务逻辑。<br>
&emsp;&emsp;function component是一个pure render component，没有state和life-cycle，如果需要这两个中的任意一个，就需要变成class component。<br>
&emsp;&emsp;在既有模式中，React的组件间通信有单向数据流和Redux等全局状态存储器。有些状态不适合放在全局的时候，就必须一层一层传递，导致组件树臃肿。<br>
&emsp;&emsp;在React Hooks中可以创建custom hook，在其中复用一些逻辑，这些逻辑不再出现在组件树中，而是独立的逻辑单元。<br>
&emsp;&emsp;所有的life-cycle，比如componentDidMount, componentDidUpdate, componentShouldUpdate集合成一个hook，叫做useEffect。























#### 100
