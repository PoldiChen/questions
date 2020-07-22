# question-middleware-ldap
some questions and answers for LDAP, Lightweight Directory Access Protocol.

#### 1. LDAP
Lightweight Directory Access Protocol 轻量级目录访问协议<br>
DN Distinguished Name 在目录树中从根出发的绝对路径，条目唯一可区别的名称，可以由DC、OU、CN组成<br>
- DC Domain Component
- OU Organizational Unit
- CN Common Name

基本数据单元是条目，条目由属性组成。<br>
对象类Object Class，是属性的集合。<br>
一个条目必须包含一个ObjectClass属性，且赋予最少一个值。<br>

ObjectClass有等级之分，最顶层是top和alias。<br>

ObjectClass可分为三类：<br>
- 结构型 Structual 比如person
- 辅助型 Auxiliary
- 抽象型 Abstract 不能直接使用，比如top

#### 100. question 100
