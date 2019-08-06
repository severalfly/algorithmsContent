分治法
=
取中间点，计算左右以及中间三部分的最大值。中间部分比较难搞，可以从中点开始向两边计算，遇到比最大值小的即停止搜索。这样，就可以完成，时间复杂度 `N log N`

扫描法
=
这种方法，在初步尝试时，是看不懂的，太神奇。直到有一天，想着先把代码抄一遍，终于理解了设计此算法的精髓，循环中分两步：一、保存当前最大值；二、保存历史最大值。

这是个很神奇的操作，计算过程中，保存部分结果，同时保存整体结果，这种思想非常好，目测可以用在一此数组遍历上