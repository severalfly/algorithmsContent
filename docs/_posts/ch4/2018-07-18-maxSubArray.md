---
layout: default
title:  最大子数组问题
---

# 最大子数组问题
使用的是分治法，将一个大问题分解成三个小问题，以中间mid
1. mid 左侧的最大子数组；
2. mid 右侧的最大子数组；
3. 紧贴着 mid 向左向右的最大子数组。

逐步分解之后，就会变成单个数的问题求解。

值得分析的是3，由 `mid` 向两侧求解最大数据，分左右侧，分别循环最大和，最大和的位置

