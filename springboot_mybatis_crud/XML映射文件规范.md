# XML映射文件规范

*     XML映射文件的名称与Mapper接口名称一致，并且将XML映射文件和Mapper接口放置在相同包下(同包同名)。
*     XML映射文件的namespace属性为Mapper接口全限定名一致。
*     XML映射文件中sql语句的id与MApper接口中的方法名一致，并保持返回类型一致。