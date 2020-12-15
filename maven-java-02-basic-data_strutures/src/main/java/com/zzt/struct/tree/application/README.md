# 二叉树的基本知识

## 二叉树的基本知识

<b>模板</b>
## 0、XXXX

**基本概念：**

> 1. 

案例：
- []()


## 1、满二叉树

**基本概念：**

> 1. 二叉树的高度的二次方幂-1，等于，所有节点数目
> 1. 2^(height)-1== nodes

案例：
- []()


## 2、完全二叉树

**基本概念：**

> 1. 有右孩子，必须左孩子
> 2. 当遇到某个左右孩子不双全时，下一个节点只是能叶子节点

**【特别适合使用宽度优先遍历】**

案例：
- [1、判断是否是完全二叉树](Tree_BFP_IsCBT_Demo01.java)


## 3、搜索二叉树

**基本概念：**

> 以 `head` 为头结点的
> 1. 左孩子节点最大值 < 头结点的值
> 2. 右孩子节点最小值 > 头结点的值

**【适合使用深度优先遍历】**

案例：
- [1、判断合法二叉搜索树](Tree_DFP_IsValidBST.java)


## 4、平衡二叉树
**基本概念：**

> 1. 以 `head` 为头结点的 左右孩子节点 的高度相差不差过 **1**

**【适合使用深度优先遍历】**

案例：


# 二叉树的基本算法 + 二叉树的递归套路


## 1、宽度优先遍历【按层遍历】[BFP]

> 1. [宽度优先遍历（返回每层的节点）](Tree_BF_Application_Demo01.java)
> 1. [判断是否是完全二叉树(按层遍历，宽度优先遍历)](Tree_BFP_IsCBT_Demo01.java)

### **小总结：**


## 2、深度优先遍历[DFP]

> 1. [判断合法二叉搜索树](Tree_DFP_IsValidBST.java)
> 1. [最大二叉搜索子树](Tree_DFP_IsValidBST.java)
> 1. [判断是否是平衡二叉树](Tree_DFP_ISBalance.java)
> 1. [任意两个节点之间的最大距离](Tree_DFP_MaxDistance.java)
> 1. [指定必须进过头结点的，两个节点之间的最大距离](Tree_DFP_MaxDistance2.java)
> 1. [二叉搜索子树的最大键值和](Tree_DFP_MaxSumBST.java)

[https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/](https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/)
