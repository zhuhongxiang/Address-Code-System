#寄递地址编码接口说明文档

---
##1. 版本历史

编号 | 文档版本 | 修订章节 | 修订原因 | 修订日期 | 修订人
--- | --- | ---|--- | --- | ---
1 | V1.0 | 初稿 | 初稿 | 2021.03.09 | 术洪祥

##2. 接口说明
###2.1 根据地址或编码模糊查询
**（1）方法基本信息**

基本信息 | 内容 
--- | --- 
方法名称 | {Host}/addressSystem/address/findBySystemIdOrAddr
方法功能 | 根据地址或编码模糊查询
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAllFullAddrIdOrAllFullAddrTextReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
searchText | String | 是 | 查询文本，根据这个字符串自动查询合适的地址或编码
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询的前置标签
postTag | String | 否 | 高亮查询的后置标签

**（3）方法输出参数**

FindByAllFullAddrIdOrAllFullAddrTextRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<AddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

AddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 是 | 完整地址信息
quId | String | 是 | 行政区编码
qu | String | 是 | 行政区
toponymId | String | 是 | 街道编码
toponym | String | 是 | 街道
haozuoId | String | 是 | 街道门牌号码编码
haozuo | String | 是 | 街道门牌号码
buildingId | String | 是 | 建筑物编码
building | String | 是 | 建筑物
seatId | String | 是 | 楼宇座号编码
seat | String | 是 | 楼宇座号
cellId | String | 是 | 楼梯编码
cell | String | 是 | 楼梯
room | String | 是 | 单元号
sxzjdId | String | 是 | 所属行政街道编码
sxzjd | String | 是 | 所属行政街道
quxcunId | String | 是 | 所属行政村/社区编码
quxcun | String | 是 | 所属行政村/社区
dycxsx | String | 是 | 未知含义号码
mapX | Double | 是 | 经度
mapY | Double | 是 | 纬度
property | String | 是 | 启用信息（启用/已停用）
orgName | String | 是 | 派出所姓名
zhBs | String | 是 | 未知含义（可能是版本号）
isDelete | Boolean | 是 | 是否删除

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
    "searchText": "90E2BA548A34",
    "pageIndex": 0,
    "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "success",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 2148,
      "allFullAddrId": "092366EA-7B15-2D44-E054-90E2BA548A34",
      "allFullAddr": "福建省闽侯县甘蔗街道榕洲路3号滨江苑A区7幢1梯401室",
      "quId": "350121",
      "qu": "福建省闽侯县",
      "toponymId": "BFC2964B-DCE3-00B6-E043-0A82290600B6",
      "toponym": "甘蔗街道榕洲路",
      "haozuoId": "1CAF9E86-6BD3-2CF5-E054-90E2BA548A34",
      "haozuo": "3号",
      "buildingId": "BFC41F0F-A5C6-01B0-E043-0A82290601B0",
      "building": "滨江苑A区",
      "seatId": "1C2C3EE0-A99B-2514-E054-90E2BA548A34",
      "seat": "7幢",
      "cellId": null,
      "cell": "4F9046E0-5806-6EE8-E054-90E2BA548A34",
      "room": "401室",
      "sxzjdId": "350121014",
      "sxzjd": "甘蔗街道",
      "quxcunId": "350121014020",
      "quxcun": "甘蔗街道滨江社区居委会",
      "dycxsx": "112",
      "mapX": 119.304001,
      "mapY": 26.087999,
      "property": "启用",
      "orgName": "闽侯县公安局甘蔗派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2149,
      "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34",
      "allFullAddr": "福建省福州市鼓楼区通湖路236号通湖公寓3座813单元",
      "quId": "350102",
      "qu": "福建省福州市鼓楼区",
      "toponymId": "BFC2964C-2DEF-00B6-E043-0A82290600B6",
      "toponym": "通湖路",
      "haozuoId": "BFC41F12-00CA-01B0-E043-0A82290601B0",
      "haozuo": "236号",
      "buildingId": "49013629-775E-04DB-E054-90E2BA54908C",
      "building": "通湖公寓",
      "seatId": "4BEE80A5-8708-7CF8-E054-90E2BA54908C",
      "seat": "3座",
      "cellId": null,
      "cell": "51E78685-BE7C-9134-E054-90E2BA510A0C",
      "room": "813单元",
      "sxzjdId": "350102003",
      "sxzjd": "南街街道",
      "quxcunId": "350102003027",
      "quxcun": "南街街道驿里社区居委会",
      "dycxsx": "111",
      "mapX": 119.147003,
      "mapY": 26.141701,
      "property": "启用",
      "orgName": "福州市公安局南街派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2155,
      "allFullAddrId": "0946FE22-6631-6D91-E054-90E2BA548A34",
      "allFullAddr": "福建省闽侯县甘蔗街道昙石山西大道69号员工公寓22幢502室",
      "quId": "350121",
      "qu": "福建省闽侯县",
      "toponymId": "BFC2964B-DCE2-00B6-E043-0A82290600B6",
      "toponym": "甘蔗街道昙石山西大道",
      "haozuoId": "BFC41F2B-B97B-01B0-E043-0A82290601B0",
      "haozuo": "69号",
      "buildingId": "BFC41F2B-EBD3-01B0-E043-0A82290601B0",
      "building": "员工公寓",
      "seatId": "1C2C3EE1-8989-2514-E054-90E2BA548A34",
      "seat": "22幢",
      "cellId": null,
      "cell": null,
      "room": "502室",
      "sxzjdId": "350121014",
      "sxzjd": "甘蔗街道",
      "quxcunId": "350121014021",
      "quxcun": "甘蔗街道瀛洲社区居委会",
      "dycxsx": "121",
      "mapX": 119.279999,
      "mapY": 26.079599,
      "property": "启用",
      "orgName": "闽侯县公安局甘蔗派出所",
      "zhBs": "2.0",
      "isDelete": false
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.2 多个字段联合查询
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/find
方法功能 | 多字段联合查询，没有模糊搜索
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 否 | 完整地址编码
allFullAddr | String | 否 | 完整地址信息
quId | String | 否 | 行政区编码
qu | String | 否 | 行政区
toponymId | String | 否 | 街道编码
toponym | String | 否 | 街道
haozuoId | String | 否 | 街道门牌号码编码
haozuo | String | 否 | 街道门牌号码
buildingId | String | 否 | 建筑物编码
building | String | 否 | 建筑物
seatId | String | 否 | 楼宇座号编码
seat | String | 否 | 楼宇座号
cellId | String | 否 | 楼梯编码
cell | String | 否 | 楼梯
room | String | 否 | 单元号
sxzjdId | String | 否 | 所属行政街道编码
sxzjd | String | 否 | 所属行政街道
quxcunId | String | 否 | 所属行政村/社区编码
quxcun | String | 否 | 所属行政村/社区
dycxsx | String | 否 | 未知含义号码
mapX | Double | 否 | 经度
mapY | Double | 否 | 纬度
property | String | 否 | 启用信息（启用/已停用）
orgName | String | 否 | 派出所姓名
zhBs | String | 否 | 未知含义（可能是版本号）
isDelete | Boolean | 否 | 是否删除
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数

**（3）方法输出参数**

FindAddressRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<AddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

AddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 是 | 完整地址信息
quId | String | 是 | 行政区编码
qu | String | 是 | 行政区
toponymId | String | 是 | 街道编码
toponym | String | 是 | 街道
haozuoId | String | 是 | 街道门牌号码编码
haozuo | String | 是 | 街道门牌号码
buildingId | String | 是 | 建筑物编码
building | String | 是 | 建筑物
seatId | String | 是 | 楼宇座号编码
seat | String | 是 | 楼宇座号
cellId | String | 是 | 楼梯编码
cell | String | 是 | 楼梯
room | String | 是 | 单元号
sxzjdId | String | 是 | 所属行政街道编码
sxzjd | String | 是 | 所属行政街道
quxcunId | String | 是 | 所属行政村/社区编码
quxcun | String | 是 | 所属行政村/社区
dycxsx | String | 是 | 未知含义号码
mapX | Double | 是 | 经度
mapY | Double | 是 | 纬度
property | String | 是 | 启用信息（启用/已停用）
orgName | String | 是 | 派出所姓名
zhBs | String | 是 | 未知含义（可能是版本号）
isDelete | Boolean | 是 | 是否删除

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "quId":"350121",
  "buildingId":"BFC41F14-1859-01B0-E043-0A82290601B0",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
    "respCode": "success",
    "respMsg": "success",
    "foundEntites": [
        {
            "id": 2152,
            "allFullAddrId": "09348BE8-E951-50B8-E054-90E2BA510A0C",
            "allFullAddr": "福建省闽侯县甘蔗街道福寿路1号福龙新村16幢1梯101室",
            "quId": "350121",
            "qu": "福建省闽侯县",
            "toponymId": "BFC2964B-DCFF-00B6-E043-0A82290600B6",
            "toponym": "甘蔗街道福寿路",
            "haozuoId": "BFC41F2C-01A4-01B0-E043-0A82290601B0",
            "haozuo": "1号",
            "buildingId": "BFC41F14-1859-01B0-E043-0A82290601B0",
            "building": "福龙新村",
            "seatId": "1C2C3EE1-3E41-2514-E054-90E2BA548A34",
            "seat": "16幢",
            "cellId": null,
            "cell": "4F9C0459-B85F-7186-E054-90E2BA548A34",
            "room": "101室",
            "sxzjdId": "350121014",
            "sxzjd": "甘蔗街道",
            "quxcunId": "350121014018",
            "quxcun": "甘蔗街道福龙社区居委会",
            "dycxsx": "121",
            "mapX": 119.280998,
            "mapY": 26.098301,
            "property": "已停用",
            "orgName": "闽侯县公安局甘蔗派出所",
            "zhBs": "2.0",
            "isDelete": false
        },
        {
            "id": 2195,
            "allFullAddrId": "0A396CE4-A14E-7A76-E054-90E2BA510A0C",
            "allFullAddr": "福建省闽侯县甘蔗街道福寿路1号福龙新村19幢1梯401室",
            "quId": "350121",
            "qu": "福建省闽侯县",
            "toponymId": "BFC2964B-DCFF-00B6-E043-0A82290600B6",
            "toponym": "甘蔗街道福寿路",
            "haozuoId": "BFC41F2C-01A4-01B0-E043-0A82290601B0",
            "haozuo": "1号",
            "buildingId": "BFC41F14-1859-01B0-E043-0A82290601B0",
            "building": "福龙新村",
            "seatId": "1C2C3EE0-89F8-2514-E054-90E2BA548A34",
            "seat": "19幢",
            "cellId": null,
            "cell": "4F143682-D8AF-3A75-E054-90E2BA548A34",
            "room": "401室",
            "sxzjdId": "350121014",
            "sxzjd": "甘蔗街道",
            "quxcunId": "350121014018",
            "quxcun": "甘蔗街道福龙社区居委会",
            "dycxsx": "121",
            "mapX": 119.179001,
            "mapY": 26.177401,
            "property": "已停用",
            "orgName": "闽侯县公安局甘蔗派出所",
            "zhBs": "2.0",
            "isDelete": false
        },
        {
            "id": 1722,
            "allFullAddrId": "0571B294-E48C-8B59-E054-90E2BA510A0C",
            "allFullAddr": "福建省闽侯县甘蔗街道福寿路1号福龙新村23幢2梯504室",
            "quId": "350121",
            "qu": "福建省闽侯县",
            "toponymId": "BFC2964B-DCFF-00B6-E043-0A82290600B6",
            "toponym": "甘蔗街道福寿路",
            "haozuoId": "BFC41F2C-01A4-01B0-E043-0A82290601B0",
            "haozuo": "1号",
            "buildingId": "BFC41F14-1859-01B0-E043-0A82290601B0",
            "building": "福龙新村",
            "seatId": "1C2C3EE0-D2B6-2514-E054-90E2BA548A34",
            "seat": "23幢",
            "cellId": null,
            "cell": "4FA084B2-A863-4966-E054-90E2BA548A34",
            "room": "504室",
            "sxzjdId": "350121014",
            "sxzjd": "甘蔗街道",
            "quxcunId": "350121014018",
            "quxcun": "甘蔗街道福龙社区居委会",
            "dycxsx": "121",
            "mapX": 119.146004,
            "mapY": 26.149401,
            "property": "已停用",
            "orgName": "闽侯县公安局甘蔗派出所",
            "zhBs": "2.0",
            "isDelete": false
        }
    ],
    "curPageIndex": 0,
    "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.3 根据编码模糊查询
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/findBySystemID
方法功能 | 根据编码查询，支持模糊搜索
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAllFullAddrIdReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 是 | 地址编码信息
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询前置标签
postTag | String | 否 | 高亮查询后置标签

**（3）方法输出参数**

FindAddressRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<AddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

AddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 是 | 完整地址信息
quId | String | 是 | 行政区编码
qu | String | 是 | 行政区
toponymId | String | 是 | 街道编码
toponym | String | 是 | 街道
haozuoId | String | 是 | 街道门牌号码编码
haozuo | String | 是 | 街道门牌号码
buildingId | String | 是 | 建筑物编码
building | String | 是 | 建筑物
seatId | String | 是 | 楼宇座号编码
seat | String | 是 | 楼宇座号
cellId | String | 是 | 楼梯编码
cell | String | 是 | 楼梯
room | String | 是 | 单元号
sxzjdId | String | 是 | 所属行政街道编码
sxzjd | String | 是 | 所属行政街道
quxcunId | String | 是 | 所属行政村/社区编码
quxcun | String | 是 | 所属行政村/社区
dycxsx | String | 是 | 未知含义号码
mapX | Double | 是 | 经度
mapY | Double | 是 | 纬度
property | String | 是 | 启用信息（启用/已停用）
orgName | String | 是 | 派出所姓名
zhBs | String | 是 | 未知含义（可能是版本号）
isDelete | Boolean | 是 | 是否删除

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddrId":"90E2BA548A34",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "success",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 2148,
      "allFullAddrId": "092366EA-7B15-2D44-E054-90E2BA548A34",
      "allFullAddr": "福建省闽侯县甘蔗街道榕洲路3号滨江苑A区7幢1梯401室",
      "quId": "350121",
      "qu": "福建省闽侯县",
      "toponymId": "BFC2964B-DCE3-00B6-E043-0A82290600B6",
      "toponym": "甘蔗街道榕洲路",
      "haozuoId": "1CAF9E86-6BD3-2CF5-E054-90E2BA548A34",
      "haozuo": "3号",
      "buildingId": "BFC41F0F-A5C6-01B0-E043-0A82290601B0",
      "building": "滨江苑A区",
      "seatId": "1C2C3EE0-A99B-2514-E054-90E2BA548A34",
      "seat": "7幢",
      "cellId": null,
      "cell": "4F9046E0-5806-6EE8-E054-90E2BA548A34",
      "room": "401室",
      "sxzjdId": "350121014",
      "sxzjd": "甘蔗街道",
      "quxcunId": "350121014020",
      "quxcun": "甘蔗街道滨江社区居委会",
      "dycxsx": "112",
      "mapX": 119.304001,
      "mapY": 26.087999,
      "property": "启用",
      "orgName": "闽侯县公安局甘蔗派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2149,
      "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34",
      "allFullAddr": "福建省福州市鼓楼区通湖路236号通湖公寓3座813单元",
      "quId": "350102",
      "qu": "福建省福州市鼓楼区",
      "toponymId": "BFC2964C-2DEF-00B6-E043-0A82290600B6",
      "toponym": "通湖路",
      "haozuoId": "BFC41F12-00CA-01B0-E043-0A82290601B0",
      "haozuo": "236号",
      "buildingId": "49013629-775E-04DB-E054-90E2BA54908C",
      "building": "通湖公寓",
      "seatId": "4BEE80A5-8708-7CF8-E054-90E2BA54908C",
      "seat": "3座",
      "cellId": null,
      "cell": "51E78685-BE7C-9134-E054-90E2BA510A0C",
      "room": "813单元",
      "sxzjdId": "350102003",
      "sxzjd": "南街街道",
      "quxcunId": "350102003027",
      "quxcun": "南街街道驿里社区居委会",
      "dycxsx": "111",
      "mapX": 119.147003,
      "mapY": 26.141701,
      "property": "启用",
      "orgName": "福州市公安局南街派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2155,
      "allFullAddrId": "0946FE22-6631-6D91-E054-90E2BA548A34",
      "allFullAddr": "福建省闽侯县甘蔗街道昙石山西大道69号员工公寓22幢502室",
      "quId": "350121",
      "qu": "福建省闽侯县",
      "toponymId": "BFC2964B-DCE2-00B6-E043-0A82290600B6",
      "toponym": "甘蔗街道昙石山西大道",
      "haozuoId": "BFC41F2B-B97B-01B0-E043-0A82290601B0",
      "haozuo": "69号",
      "buildingId": "BFC41F2B-EBD3-01B0-E043-0A82290601B0",
      "building": "员工公寓",
      "seatId": "1C2C3EE1-8989-2514-E054-90E2BA548A34",
      "seat": "22幢",
      "cellId": null,
      "cell": null,
      "room": "502室",
      "sxzjdId": "350121014",
      "sxzjd": "甘蔗街道",
      "quxcunId": "350121014021",
      "quxcun": "甘蔗街道瀛洲社区居委会",
      "dycxsx": "121",
      "mapX": 119.279999,
      "mapY": 26.079599,
      "property": "启用",
      "orgName": "闽侯县公安局甘蔗派出所",
      "zhBs": "2.0",
      "isDelete": false
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.4 根据地址模糊查询
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/findByAddr
方法功能 | 根据地址查询，支持模糊搜索
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAllFullAddrReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddr | String | 是 | 地址信息
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询前置标签
postTag | String | 否 | 高亮查询后置标签

**（3）方法输出参数**

FindAddressRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<AddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

AddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 是 | 完整地址信息
quId | String | 是 | 行政区编码
qu | String | 是 | 行政区
toponymId | String | 是 | 街道编码
toponym | String | 是 | 街道
haozuoId | String | 是 | 街道门牌号码编码
haozuo | String | 是 | 街道门牌号码
buildingId | String | 是 | 建筑物编码
building | String | 是 | 建筑物
seatId | String | 是 | 楼宇座号编码
seat | String | 是 | 楼宇座号
cellId | String | 是 | 楼梯编码
cell | String | 是 | 楼梯
room | String | 是 | 单元号
sxzjdId | String | 是 | 所属行政街道编码
sxzjd | String | 是 | 所属行政街道
quxcunId | String | 是 | 所属行政村/社区编码
quxcun | String | 是 | 所属行政村/社区
dycxsx | String | 是 | 未知含义号码
mapX | Double | 是 | 经度
mapY | Double | 是 | 纬度
property | String | 是 | 启用信息（启用/已停用）
orgName | String | 是 | 派出所姓名
zhBs | String | 是 | 未知含义（可能是版本号）
isDelete | Boolean | 是 | 是否删除

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddr":"美岐小区",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "success",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 2147,
      "allFullAddrId": "091FDA17-1519-7181-E054-90E2BA510A0C",
      "allFullAddr": "福建省福州市鼓楼区卫前街11号冠城三牧苑3座822单元",
      "quId": "350102",
      "qu": "福建省福州市鼓楼区",
      "toponymId": "BFC2964C-737B-00B6-E043-0A82290600B6",
      "toponym": "卫前街",
      "haozuoId": "1C5E52E4-EEE2-12FF-E054-90E2BA548A34",
      "haozuo": "11号",
      "buildingId": "FA85995C-66F3-019E-E043-0A822905019E",
      "building": "冠城三牧苑",
      "seatId": "4F9F77F8-2862-BA26-E054-90E2BA510A0C",
      "seat": "3座",
      "cellId": null,
      "cell": "52709B90-5A70-2938-E054-90E2BA548A34",
      "room": "822单元",
      "sxzjdId": "350102006",
      "sxzjd": "东街街道",
      "quxcunId": "350102006016",
      "quxcun": "东街街道旗汛口社区居委会",
      "dycxsx": "111",
      "mapX": 119.293999,
      "mapY": 26.084999,
      "property": "启用",
      "orgName": "福州市公安局东街派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2148,
      "allFullAddrId": "092366EA-7B15-2D44-E054-90E2BA548A34",
      "allFullAddr": "福建省闽侯县甘蔗街道榕洲路3号滨江苑A区7幢1梯401室",
      "quId": "350121",
      "qu": "福建省闽侯县",
      "toponymId": "BFC2964B-DCE3-00B6-E043-0A82290600B6",
      "toponym": "甘蔗街道榕洲路",
      "haozuoId": "1CAF9E86-6BD3-2CF5-E054-90E2BA548A34",
      "haozuo": "3号",
      "buildingId": "BFC41F0F-A5C6-01B0-E043-0A82290601B0",
      "building": "滨江苑A区",
      "seatId": "1C2C3EE0-A99B-2514-E054-90E2BA548A34",
      "seat": "7幢",
      "cellId": null,
      "cell": "4F9046E0-5806-6EE8-E054-90E2BA548A34",
      "room": "401室",
      "sxzjdId": "350121014",
      "sxzjd": "甘蔗街道",
      "quxcunId": "350121014020",
      "quxcun": "甘蔗街道滨江社区居委会",
      "dycxsx": "112",
      "mapX": 119.304001,
      "mapY": 26.087999,
      "property": "启用",
      "orgName": "闽侯县公安局甘蔗派出所",
      "zhBs": "2.0",
      "isDelete": false
    },
    {
      "id": 2149,
      "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34",
      "allFullAddr": "福建省福州市鼓楼区通湖路236号通湖公寓3座813单元",
      "quId": "350102",
      "qu": "福建省福州市鼓楼区",
      "toponymId": "BFC2964C-2DEF-00B6-E043-0A82290600B6",
      "toponym": "通湖路",
      "haozuoId": "BFC41F12-00CA-01B0-E043-0A82290601B0",
      "haozuo": "236号",
      "buildingId": "49013629-775E-04DB-E054-90E2BA54908C",
      "building": "通湖公寓",
      "seatId": "4BEE80A5-8708-7CF8-E054-90E2BA54908C",
      "seat": "3座",
      "cellId": null,
      "cell": "51E78685-BE7C-9134-E054-90E2BA510A0C",
      "room": "813单元",
      "sxzjdId": "350102003",
      "sxzjd": "南街街道",
      "quxcunId": "350102003027",
      "quxcun": "南街街道驿里社区居委会",
      "dycxsx": "111",
      "mapX": 119.147003,
      "mapY": 26.141701,
      "property": "启用",
      "orgName": "福州市公安局南街派出所",
      "zhBs": "2.0",
      "isDelete": false
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.5 添加地址
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/addAddress
方法功能 | 添加地址
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

AddAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 是 | 完整地址信息
quId | String | 是 | 行政区编码
qu | String | 是 | 行政区
toponymId | String | 是 | 街道编码
toponym | String | 是 | 街道
haozuoId | String | 是 | 街道门牌号码编码
haozuo | String | 是 | 街道门牌号码
buildingId | String | 是 | 建筑物编码
building | String | 是 | 建筑物
seatId | String | 是 | 楼宇座号编码
seat | String | 是 | 楼宇座号
cellId | String | 是 | 楼梯编码
cell | String | 是 | 楼梯
room | String | 是 | 单元号
sxzjdId | String | 是 | 所属行政街道编码
sxzjd | String | 是 | 所属行政街道
quxcunId | String | 是 | 所属行政村/社区编码
quxcun | String | 是 | 所属行政村/社区
dycxsx | String | 是 | 未知含义号码
mapX | Double | 是 | 经度
mapY | Double | 是 | 纬度
property | String | 是 | 启用信息（启用/已停用）
orgName | String | 是 | 派出所姓名
zhBs | String | 是 | 未知含义（可能是版本号）

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34",
  "allFullAddr": "福建省福州市鼓楼区通湖路236号通湖公寓3座813单元",
  "quId": "350102",
  "qu": "福建省福州市鼓楼区",
  "toponymId": "BFC2964C-2DEF-00B6-E043-0A82290600B6",
  "toponym": "通湖路",
  "haozuoId": "BFC41F12-00CA-01B0-E043-0A82290601B0",
  "haozuo": "236号",
  "buildingId": "49013629-775E-04DB-E054-90E2BA54908C",
  "building": "通湖公寓",
  "seatId": "4BEE80A5-8708-7CF8-E054-90E2BA54908C",
  "seat": "3座",
  "cellId": null,
  "cell": "51E78685-BE7C-9134-E054-90E2BA510A0C",
  "room": "813单元",
  "sxzjdId": "350102003",
  "sxzjd": "南街街道",
  "quxcunId": "350102003027",
  "quxcun": "南街街道驿里社区居委会",
  "dycxsx": "111",
  "mapX": 119.147003,
  "mapY": 26.141701,
  "property": "启用",
  "orgName": "福州市公安局南街派出所",
  "zhBs": "2.0"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>

###2.6 更新地址信息
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/updateAddress
方法功能 | 更新地址信息
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

UpdateAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 是 | 完整地址编码
allFullAddr | String | 否 | 完整地址信息
quId | String | 否 | 行政区编码
qu | String | 否 | 行政区
toponymId | String | 否 | 街道编码
toponym | String | 否 | 街道
haozuoId | String | 否 | 街道门牌号码编码
haozuo | String | 否 | 街道门牌号码
buildingId | String | 否 | 建筑物编码
building | String | 否 | 建筑物
seatId | String | 否 | 楼宇座号编码
seat | String | 否 | 楼宇座号
cellId | String | 否 | 楼梯编码
cell | String | 否 | 楼梯
room | String | 否 | 单元号
sxzjdId | String | 否 | 所属行政街道编码
sxzjd | String | 否 | 所属行政街道
quxcunId | String | 否 | 所属行政村/社区编码
quxcun | String | 否 | 所属行政村/社区
dycxsx | String | 否 | 未知含义号码
mapX | Double | 否 | 经度
mapY | Double | 否 | 纬度
property | String | 否 | 启用信息（启用/已停用）
orgName | String | 否 | 派出所姓名
zhBs | String | 否 | 未知含义（可能是版本号）

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34",
  "room": "814单元"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>

###2.7 根据地址编码删除地址信息
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/address/deleteAddressByAllFullAddrId
方法功能 | 根据地址编码删除地址信息
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

DeleteAddressByAllFullAddrIdReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 是 | 完整地址编码

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddrId": "09237A79-8AB7-69F1-E054-90E2BA548A34"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>

###2.8 查询所有配送路径
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/route/findAll
方法功能 | 查询所有配送路径
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

无

**（3）方法输出参数**

FindAllRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
addrList | List\<RouteESEntity>  | 是 | 查询到的地址信息

RouteESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
orderId | String | 是 | 订单编号
address | String | 是 | 配送地址
customerName | String | 是 | 顾客姓名
customerTel | String | 是 | 顾客联系方式
postmanId | String | 是 | 配送员编号
postmanName | String | 是 | 配送员姓名
postmanTel | String | 是 | 配送员手机号
status | String | 是 | 状态

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "success",
  "respMsg": "success",
  "addrList": [
    {
      "id": 4,
      "orderId": "O004",
      "address": "福建省福州市鼓楼区融侨路35号鑫亭新苑8座4C单元",
      "customerName": "张山山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    },
    {
      "id": 3,
      "orderId": "O003",
      "address": "福建省福州市鼓楼区东城边街31号灰炉新苑1座2703单元",
      "customerName": "王道",
      "customerTel": "15578786542",
      "postmanId": "1",
      "postmanName": "谢剑锋",
      "postmanTel": "17654239865",
      "status": 0
    },
    {
      "id": 2,
      "orderId": "O002",
      "address": "福建省福州市鼓楼区丞相路10号五凤兰庭33座101单元",
      "customerName": "李牛",
      "customerTel": "17754338888",
      "postmanId": "1",
      "postmanName": "王德发",
      "postmanTel": "18842665422",
      "status": 0
    },
    {
      "id": 1,
      "orderId": "O001",
      "address": "福建省福州市鼓楼区杨桥西路28号3座603单元",
      "customerName": "张山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    }
  ]
}
```
</td>
</tr>
</table>

###2.9 根据配送员id查询配送路径列表
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/route/findByPostmanId
方法功能 | 根据配送员id查询配送路径列表
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByPostmanIdDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
postmanId | String | 是 | 配送员id

**（3）方法输出参数**

FindByPostmanIdRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
addrList | List\<RouteESEntity>  | 是 | 查询到的地址信息

RouteESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
orderId | String | 是 | 订单编号
address | String | 是 | 配送地址
customerName | String | 是 | 顾客姓名
customerTel | String | 是 | 顾客联系方式
postmanId | String | 是 | 配送员编号
postmanName | String | 是 | 配送员姓名
postmanTel | String | 是 | 配送员手机号
status | String | 是 | 状态

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "postmanId": "1"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "success",
  "respMsg": "success",
  "addrList": [
    {
      "id": 4,
      "orderId": "O004",
      "address": "福建省福州市鼓楼区融侨路35号鑫亭新苑8座4C单元",
      "customerName": "张山山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    },
    {
      "id": 3,
      "orderId": "O003",
      "address": "福建省福州市鼓楼区东城边街31号灰炉新苑1座2703单元",
      "customerName": "王道",
      "customerTel": "15578786542",
      "postmanId": "1",
      "postmanName": "谢剑锋",
      "postmanTel": "17654239865",
      "status": 0
    },
    {
      "id": 2,
      "orderId": "O002",
      "address": "福建省福州市鼓楼区丞相路10号五凤兰庭33座101单元",
      "customerName": "李牛",
      "customerTel": "17754338888",
      "postmanId": "1",
      "postmanName": "王德发",
      "postmanTel": "18842665422",
      "status": 0
    },
    {
      "id": 1,
      "orderId": "O001",
      "address": "福建省福州市鼓楼区杨桥西路28号3座603单元",
      "customerName": "张山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    }
  ]
}
```
</td>
</tr>
</table>

###2.10 根据配送员id查询配送路径列表(有序)
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/route/findByPostmanIdSort
方法功能 | 根据配送员id查询配送路径列表(有序)
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByPostmanIdDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
postmanId | String | 是 | 配送员id

**（3）方法输出参数**

FindByPostmanIdRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
addrList | List\<RouteESEntity>  | 是 | 查询到的地址信息

RouteESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
orderId | String | 是 | 订单编号
address | String | 是 | 配送地址
customerName | String | 是 | 顾客姓名
customerTel | String | 是 | 顾客联系方式
postmanId | String | 是 | 配送员编号
postmanName | String | 是 | 配送员姓名
postmanTel | String | 是 | 配送员手机号
status | String | 是 | 状态

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "postmanId": "1"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success",
  "addrSortList": [
    {
      "id": 1,
      "orderId": "O001",
      "address": "福建省福州市鼓楼区杨桥西路28号3座603单元",
      "customerName": "张山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    },
    {
      "id": 2,
      "orderId": "O002",
      "address": "福建省福州市鼓楼区丞相路10号五凤兰庭33座101单元",
      "customerName": "李牛",
      "customerTel": "17754338888",
      "postmanId": "1",
      "postmanName": "王德发",
      "postmanTel": "18842665422",
      "status": 0
    },
    {
      "id": 3,
      "orderId": "O003",
      "address": "福建省福州市鼓楼区东城边街31号灰炉新苑1座2703单元",
      "customerName": "王道",
      "customerTel": "15578786542",
      "postmanId": "1",
      "postmanName": "谢剑锋",
      "postmanTel": "17654239865",
      "status": 0
    },
    {
      "id": 4,
      "orderId": "O004",
      "address": "福建省福州市鼓楼区融侨路35号鑫亭新苑8座4C单元",
      "customerName": "张山山",
      "customerTel": "16652334655",
      "postmanId": "1",
      "postmanName": "黄大宝",
      "postmanTel": "19942668787",
      "status": 0
    }
  ]
}
```
</td>
</tr>
</table>

###2.11 根据地址或编码模糊查询标准数据库
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/findByAddrCodeOrName
方法功能 | 根据地址或编码模糊查询标准数据库
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAddrCodeOrNameReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
searchText | String | 是 | 查询文本，根据这个字符串自动查询合适的地址或编码
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询的前置标签
postTag | String | 否 | 高亮查询的后置标签

**（3）方法输出参数**

FindByAddrCodeOrNameRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<StandardAddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

StandardAddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 是 | 标准地址
provinceCode | String | 是 | 省编号
provinceName | String | 是 | 省名称
latitude | String | 是 | 纬度
longitude | String | 是 | 经度
status | String | 是 | 提交状态
createUser | String | 是 | 创建者
updateUser | String | 是 | 更新者
createTime | LocalDateTime | 是 | 创建时间
updateTime | LocalDateTime | 是 | 更新时间
ts | LocalDateTime | 是 | 时间戳
yn | Boolean | 是 | 是否删除标识

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
    "searchText": "新城丽景",
    "pageIndex": 0,
    "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 843632,
      "fullAddressCode": "78F6EA7B-834D-8E90-E054-90E2BA510A0C",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区物业",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.163",
      "longitude": "118.990997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6507,
      "fullAddressCode": "1C2C3EE0-86C6-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区8幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.0888",
      "longitude": "119.300003",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6560,
      "fullAddressCode": "1C2C3EE0-8AFD-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山西大道98号新城丽景B区9幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.1033",
      "longitude": "119.283997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.12 多个字段联合查询标准数据库
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/find
方法功能 | 多个字段联合查询标准数据库，没有模糊搜索
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindStandardAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
fullAddressCode | String | 否 | 标准地址编码
fullAddress | String | 否 | 标准地址
provinceCode | Integer | 否 | 省编号
provinceName | String | 否 | 省名称
latitude | String | 否 | 纬度
longitude | String | 否 | 经度
status | String | 否 | 提交状态
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数

**（3）方法输出参数**

FindByAddrCodeOrNameRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<StandardAddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

StandardAddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 是 | 标准地址
provinceCode | String | 是 | 省编号
provinceName | String | 是 | 省名称
latitude | String | 是 | 纬度
longitude | String | 是 | 经度
status | String | 是 | 提交状态
createUser | String | 是 | 创建者
updateUser | String | 是 | 更新者
createTime | LocalDateTime | 是 | 创建时间
updateTime | LocalDateTime | 是 | 更新时间
ts | LocalDateTime | 是 | 时间戳
yn | Boolean | 是 | 是否删除标识

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "provinceName": "福建省",
  "status": "committed",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 64956,
      "fullAddressCode": "4DA347EB-B330-92A5-E054-90E2BA510A0C",
      "fullAddress": "福建省福州市鼓楼区湖东路98号1座Z011",
      "provinceCode": null,
      "provinceName": "福建省",
      "latitude": "26.101101",
      "longitude": "119.278999",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 64957,
      "fullAddressCode": "4DA347EB-B331-92A5-E054-90E2BA510A0C",
      "fullAddress": "福建省福州市鼓楼区湖东路98号1座Z014",
      "provinceCode": null,
      "provinceName": "福建省",
      "latitude": "26.101801",
      "longitude": "119.274002",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 64958,
      "fullAddressCode": "4DA347EB-B332-92A5-E054-90E2BA510A0C",
      "fullAddress": "福建省福州市鼓楼区湖东路98号1座水泵房",
      "provinceCode": null,
      "provinceName": "福建省",
      "latitude": "26.1015",
      "longitude": "119.274002",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.13 添加标准数据
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/addAddress
方法功能 | 添加标准数据
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

AddStandardAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 是 | 标准地址
provinceCode | Integer | 是 | 省编号
provinceName | String | 是 | 省名称
latitude | String | 是 | 纬度
longitude | String | 是 | 经度
status | String | 是 | 提交状态

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "fullAddressCode": "00005B14-292A-2989-E054-90E2BA123456",
  "fullAddress": "福建省闽侯县甘蔗街道昙石山西大道98号新城丽景B区13幢2梯304单元",
  "provinceCode": 0,
  "provinceName": "福建省",
  "latitude": "26.1425",
  "longitude": "119.150002",
  "status": "committed"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>

###2.14 根据标准数据编码删除标准数据
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/deleteAddressByFullAddrCode
方法功能 | 根据标准数据编码删除标准数据
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

DeleteAddressByFullAddrCodeReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
fullAddressCode | String | 是 | 标准地址编码

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "fullAddressCode": "00005B14-292A-2989-E054-90E2BA123456"
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>

###2.15 更新标准数据
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/updateAddress
方法功能 | 更新标准数据
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

UpdateStandardAddressReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 否 | 标准地址
provinceCode | Integer | 否 | 省编号
provinceName | String | 否 | 省名称
latitude | String | 否 | 纬度
longitude | String | 否 | 经度
status | String | 否 | 提交状态

**（3）方法输出参数**

BaseRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
respCode | String | 是 | 响应码
respMsg | String | 是 | 响应信息

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "fullAddressCode": "00005B14-292A-2989-E054-90E2BA548A34",
  "provinceCode": 20
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success"
}
```
</td>
</tr>
</table>


###2.16根据编码模糊查询标准数据库
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/findByAddrCode
方法功能 | 根据编码模糊查询标准数据库
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAllFullAddrIdReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddrId | String | 是 | 地址编码信息
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询前置标签
postTag | String | 否 | 高亮查询后置标签

**（3）方法输出参数**

FindByAddrCodeOrNameRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<StandardAddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

StandardAddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 是 | 标准地址
provinceCode | String | 是 | 省编号
provinceName | String | 是 | 省名称
latitude | String | 是 | 纬度
longitude | String | 是 | 经度
status | String | 是 | 提交状态
createUser | String | 是 | 创建者
updateUser | String | 是 | 更新者
createTime | LocalDateTime | 是 | 创建时间
updateTime | LocalDateTime | 是 | 更新时间
ts | LocalDateTime | 是 | 时间戳
yn | Boolean | 是 | 是否删除标识

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddrId":"90E2BA548A34",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 843632,
      "fullAddressCode": "78F6EA7B-834D-8E90-E054-90E2BA510A0C",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区物业",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.163",
      "longitude": "118.990997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6507,
      "fullAddressCode": "1C2C3EE0-86C6-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区8幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.0888",
      "longitude": "119.300003",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6560,
      "fullAddressCode": "1C2C3EE0-8AFD-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山西大道98号新城丽景B区9幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.1033",
      "longitude": "119.283997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>

###2.17根据地址模糊查询标准数据库
**（1）方法基本信息**

基本信息 | 内容
--- | --- 
方法名称 | {Host}/addressSystem/standardAddress/findByAddr
方法功能 | 根据地址模糊查询标准数据库
域名地址 | 10.101.164.41:8080
注意事项 | Content-Type要设置为application/json;charset=utf-8
协议 | http

**（2）方法输入参数**

FindByAllFullAddrReqDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
allFullAddr | String | 是 | 地址信息
pageIndex | Integer | 是 | 当前的页面序号（0开始）
pageSize | Integer | 是 | 一页展示的条目数
preTag | String | 否 | 高亮查询前置标签
postTag | String | 否 | 高亮查询后置标签

**（3）方法输出参数**

FindByAddrCodeOrNameRespDTO

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
foundEntites | List\<StandardAddressESEntity>  | 是 | 查询到的地址信息
curPageIndex | Integer | 是 | 当前的页面序号
curPageSize | Integer | 是 | 当前一页展示的条目数

StandardAddressESEntity

字段 | 类型 | 是否必须 | 描述
--- | --- | --- | ---
id | Long  | 是 | 编码
fullAddressCode | String | 是 | 标准地址编码
fullAddress | String | 是 | 标准地址
provinceCode | String | 是 | 省编号
provinceName | String | 是 | 省名称
latitude | String | 是 | 纬度
longitude | String | 是 | 经度
status | String | 是 | 提交状态
createUser | String | 是 | 创建者
updateUser | String | 是 | 更新者
createTime | LocalDateTime | 是 | 创建时间
updateTime | LocalDateTime | 是 | 更新时间
ts | LocalDateTime | 是 | 时间戳
yn | Boolean | 是 | 是否删除标识

**（4）实例**

<table>
<tr>
<th>入参</th>
<td>

```json
{
  "allFullAddr":"美岐小区",
  "pageIndex": 0,
  "pageSize": 3
}
```
</td>
</tr>
<tr>
<th>出参</th>
<td>

```json
{
  "respCode": "200",
  "respMsg": "success",
  "foundEntites": [
    {
      "id": 843632,
      "fullAddressCode": "78F6EA7B-834D-8E90-E054-90E2BA510A0C",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区物业",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.163",
      "longitude": "118.990997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6507,
      "fullAddressCode": "1C2C3EE0-86C6-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山中大道118号新城丽景A区8幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.0888",
      "longitude": "119.300003",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    },
    {
      "id": 6560,
      "fullAddressCode": "1C2C3EE0-8AFD-2514-E054-90E2BA548A34",
      "fullAddress": "福建省闽侯县甘蔗街道昙石山西大道98号新城丽景B区9幢",
      "proviceCode": 0,
      "provinceName": "福建省",
      "latitude": "26.1033",
      "longitude": "119.283997",
      "status": "committed",
      "createUser": null,
      "updateUser": null,
      "createTime": "2020-12-23T07:05:49",
      "updateTime": "2020-12-23T08:01:48",
      "ts": "2020-12-23T08:01:48",
      "yn": true
    }
  ],
  "curPageIndex": 0,
  "curPageSize": 3
}
```
</td>
</tr>
</table>