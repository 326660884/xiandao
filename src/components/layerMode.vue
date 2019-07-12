<template>
	<el-container >
        <el-header style="font-size: 20px;">安全事件详情</el-header>
        <el-main>
            <el-table
            :data="tableData"
            style="width: 100%">
                <el-table-column
                    prop="date"
                    label="日期"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="source"
                    label="攻击源"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="target"
                    label="攻击目标">
                </el-table-column>
                <el-table-column
                    prop="number"
                    label="次数">
                </el-table-column>
            </el-table>    
        </el-main>
    </el-container>
</template>

<script>
    export default {
      data() {
        return {
          tableData: [{
            date: '2019-07-11',
            source:'中国联通',
            target:'159.168.101.12',
            number:'86039'
          },{
            date: '2019-07-11',
            source:'中国联通',
            target:'159.168.101.12',
            number:'86039'
          },{
            date: '2019-07-11',
            source:'中国联通',
            target:'159.168.101.12',
            number:'86039'
          },{
            date: '2019-07-11',
            source:'中国联通',
            target:'159.168.101.12',
            number:'86039'
          }]
        }
      }
    }
  </script>