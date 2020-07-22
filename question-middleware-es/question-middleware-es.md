# question-middleware-es
some questions and answers for Elasticsearch

#### 1. Elasticsearch
基于Apache Lucene的开源搜索引擎，通过简单的RESTful API来隐藏Lucene的复杂性，让全文搜索变得简单。
- 分布式的实时文件存储，每个字段都被索引并可被搜索
- 分布式的实时分析搜索引擎
- 可以扩展到上百台服务器，处理PB级别结构化或非结构化数据

面向文档，可以存储整个对象或者文档，并且索引每个文档的内容使之可被搜索。

库（Databases）-> 表（Tables）-> 行（Rows）-> 列（Columns）<br>
索引（Indices）-> 类型（Types）-> 文档（Documents）-> 字段（Fields）

Elasticsearch提供丰富且灵活的查询语言，DSL查询（Query DSL），可以构建复杂、强大的查询.<br>
DSL（Domain Specific Language）特定领域语言，以JSON格式构建查询请求。

```json
GET /megacorp/employee/_search
{
	"query": {
		"match": {
			"last_name": "Smith"
		}
	}
}

{
	"query": {
		"bool": {
			"filter": {
				"range": {
					"age": {
						"gt": 30
					}
				}
			},
			"must": {
				"match": {
					"last_name": "Smith"
				}
			}
		}
	}
}
```
#### 100. question 100
