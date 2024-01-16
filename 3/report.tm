<TeXmacs|2.1.2>

<style|<tuple|generic|greek|fira-font>>

<\body>
  <doc-data|<doc-title|\<#394\>\<#3BF\>\<#3BC\>\<#3AD\>\<#3C2\>
  \<#394\>\<#3B5\>\<#3B4\>\<#3BF\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3C9\>\<#3BD\>:
  \<#395\>\<#3C1\>\<#3B3\>\<#3B1\>\<#3C3\>\<#3AF\>\<#3B1\>
  3>|<doc-subtitle|\<#39C\>\<#3AD\>\<#3B8\>\<#3BF\>\<#3B4\>\<#3BF\>\<#3B9\>
  \<#3C4\>\<#3BF\>\<#3C5\> RandomizedBST>|<doc-author|<author-data|<\author-name>
    \<#392\>\<#3B1\>\<#3C3\>\<#3B9\>\<#3BB\>\<#3B7\>\<#3C3\>
    \<#3A0\>\<#3B1\>\<#3C0\>\<#3B1\>\<#3B4\>\<#3B7\>\<#3BC\>\<#3B1\>\<#3C3\>
    (3220150) & \<#39C\>\<#3B1\>\<#3C1\>\<#3B9\>\<#3BF\>\<#3C3\>
    \<#39C\>\<#3B1\>\<#3C4\>\<#3C3\>\<#3B1\> (3220120)
  </author-name>>>>

  <section*|<itemize|void insert(LargeDepositor item)>>

  \<#3A7\>\<#3C1\>\<#3B7\>\<#3C3\>\<#3B9\>\<#3BC\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B7\>\<#3BD\> TreeNode foundByAFM(int AFM)
  \<#3B3\>\<#3B9\>\<#3B1\> \<#3BD\>\<#3B1\>
  \<#3B2\>\<#3C1\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\> \<#3B1\>\<#3BD\>
  \<#3C5\>\<#3C0\>\<#3AC\>\<#3C1\>\<#3C7\>\<#3B5\>\<#3B9\>
  \<#3AE\>\<#3B4\>\<#3B7\> \<#3BA\>\<#3AC\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3BF\>
  TreeNode \<#3C3\>\<#3C4\>\<#3BF\> \<#3B4\>\<#3AD\>\<#3BD\>\<#3C4\>\<#3C1\>\<#3BF\>
  \<#3BC\>\<#3B5\> \<#3AF\>\<#3B4\>\<#3B9\>\<#3BF\> \<#391\>\<#3A6\>\<#39C\>
  \<#3BC\>\<#3B5\> \<#3C4\>\<#3BF\>\<#3C5\> item (O(N)). \<#391\>\<#3BD\>
  \<#3BD\>\<#3B1\>\<#3B9\> (curr != null) \<#3C4\>\<#3CC\>\<#3C4\>\<#3B5\>
  \<#3B5\>\<#3BA\>\<#3C4\>\<#3C5\>\<#3C0\>\<#3CE\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#3BC\>\<#3AE\>\<#3BD\>\<#3C5\>\<#3BC\>\<#3B1\>,
  \<#3B1\>\<#3BB\>\<#3BB\>\<#3B9\>\<#3CE\>\<#3C2\>
  \<#3B8\>\<#3AD\>\<#3C4\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\> root =
  insertAsRoot(root, item) \<#3BA\>\<#3B1\>\<#3B9\>
  \<#3B1\>\<#3C5\>\<#3BE\>\<#3AC\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#39D\> \<#3C4\>\<#3BF\>\<#3C5\> root. \<#397\> TreeNode
  insertAsRoot(TreeNode h, LargeDepositor x) (O(log_2(N)))
  \<#3BA\>\<#3B1\>\<#3B9\> \<#3B7\> TreeNode insertT(TreeNode h,
  LargeDepositor x) (O(log_2(N))) \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3C7\>\<#3C1\>\<#3B7\>\<#3C3\>\<#3B9\>\<#3BC\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3B5\>\<#3AF\>
  (\<#3BA\>\<#3B1\>\<#3B9\> \<#3BF\>\<#3B9\> TreeNode rotR(TreeNode h) (O(1))
  \<#3BA\>\<#3B1\>\<#3B9\> TreeNode rotL(TreeNode h) (O(1))
  \<#3C0\>\<#3BF\>\<#3C5\> \<#3C7\>\<#3C1\>\<#3B7\>\<#3C3\>\<#3B9\>\<#3BC\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3B5\>\<#3AF\>
  \<#3B5\>\<#3BA\>\<#3B5\>\<#3AF\>\<#3BD\>\<#3B7\>)
  \<#3AD\>\<#3C7\>\<#3BF\>\<#3C5\>\<#3BD\>
  \<#3C5\>\<#3BB\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3B7\>\<#3B8\>\<#3B5\>\<#3AF\>
  \<#3CC\>\<#3BB\>\<#3B5\>\<#3C2\> \<#3C3\>\<#3CD\>\<#3BC\>\<#3D5\>\<#3C9\>\<#3BD\>\<#3B1\>
  \<#3BC\>\<#3B5\> \<#3C4\>\<#3B1\> \<#3C0\>\<#3B1\>\<#3C1\>\<#3B1\>\<#3B4\>\<#3B5\>\<#3AF\>\<#3B3\>\<#3BC\>\<#3B1\>\<#3C4\>\<#3B1\>
  \<#3C0\>\<#3BF\>\<#3C5\> \<#3AD\>\<#3C7\>\<#3BF\>\<#3C5\>\<#3BD\>
  \<#3B4\>\<#3BF\>\<#3B8\>\<#3B5\>\<#3AF\> \<#3C3\>\<#3C4\>\<#3B1\>
  \<#3C0\>\<#3BB\>\<#3AC\>\<#3B9\>\<#3C3\>\<#3B9\>\<#3B1\>
  \<#3C4\>\<#3BF\>\<#3C5\> \<#3BC\>\<#3B1\>\<#3B8\>\<#3AE\>\<#3BC\>\<#3B1\>\<#3C4\>\<#3BF\>\<#3C2\>.

  <with|font-series|bold|Time complexity>: O(log_2(N))

  <section*|<itemize|<itemize|void load(String filename)>>>

  \<#394\>\<#3B9\>\<#3B1\>\<#3B2\>\<#3AC\>\<#3B6\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C3\>\<#3B5\>\<#3B9\>\<#3C1\>\<#3B9\>\<#3B1\>\<#3BA\>\<#3AC\>
  \<#3C4\>\<#3BF\> \<#3B1\>\<#3C1\>\<#3C7\>\<#3B5\>\<#3AF\>\<#3BF\>
  \<#3C0\>\<#3BF\>\<#3C5\> \<#3BF\>\<#3C1\>\<#3AF\>\<#3B6\>\<#3B5\>\<#3B9\>
  \<#3C4\>\<#3BF\> filename (O(N)), \<#3C3\>\<#3C0\>\<#3AC\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B7\>\<#3BD\> \<#3BA\>\<#3AC\>\<#3B8\>\<#3B5\>
  \<#3B3\>\<#3C1\>\<#3B1\>\<#3BC\>\<#3BC\>\<#3AE\> \<#3C3\>\<#3B5\>
  substrings \<#3BC\>\<#3B5\> spacer \<#3C4\>\<#3B1\>
  \<#3BA\>\<#3B5\>\<#3BD\>\<#3AC\> \<#3BC\>\<#3AD\>\<#3C3\>\<#3C9\> regex
  (O(\<#3BC\>\<#3AE\>\<#3BA\>\<#3BF\>\<#3C2\>
  \<#3B3\>\<#3C1\>\<#3B1\>\<#3BC\>\<#3BC\>\<#3AE\>\<#3C2\>
  \<#3B3\>\<#3B9\>\<#3B1\> regex \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\> \<#3BC\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3C4\>\<#3C1\>\<#3B1\>\<#3C0\>\<#3B5\>\<#3AF\>
  \<#3C3\>\<#3B5\> finite automaton \<#3BC\>\<#3B5\>
  \<#3C5\>\<#3C0\>\<#3CC\>\<#3B8\>\<#3B5\>\<#3C3\>\<#3B7\> 3 spacers
  \<#3B1\>\<#3BD\>\<#3B1\> \<#3B3\>\<#3C1\>\<#3B1\>\<#3BC\>\<#3BC\>\<#3AE\>),
  \<#3C0\>\<#3C1\>\<#3B1\>\<#3BA\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3AC\>
  \<#3C3\>\<#3C4\>\<#3B1\>\<#3B8\>\<#3B5\>\<#3C1\>\<#3CC\>\<#3C2\>
  \<#3CC\>\<#3C1\>\<#3BF\>\<#3C2\> \<#39F\>(1)),
  \<#3B4\>\<#3B7\>\<#3BC\>\<#3B9\>\<#3BF\>\<#3C5\>\<#3C1\>\<#3B3\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3B1\>\<#3BD\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3B5\>\<#3AF\>\<#3BC\>\<#3B5\>\<#3BD\>\<#3B1\>
  LargeDepositor \<#3BC\>\<#3B5\> \<#3C4\>\<#3B1\>
  \<#3BA\>\<#3B1\>\<#3C4\>\<#3AC\>\<#3BB\>\<#3BB\>\<#3B7\>\<#3BB\>\<#3B1\>
  \<#3B4\>\<#3B5\>\<#3B4\>\<#3BF\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3B1\>
  \<#3B1\>\<#3C0\>\<#3CC\> \<#3C4\>\<#3B1\> strings (\<#3C0\>\<#3BF\>\<#3C5\>
  \<#3CC\>\<#3C4\>\<#3B1\>\<#3BD\> \<#3C7\>\<#3C1\>\<#3B5\>\<#3B9\>\<#3AC\>\<#3B6\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3B9\>
  \<#3BC\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3C4\>\<#3C1\>\<#3AD\>\<#3C0\>\<#3BF\>\<#3BD\>\<#3C4\>\<#3B1\>\<#3B9\>
  \<#3C3\>\<#3B5\> \<#3AC\>\<#3BB\>\<#3BB\>\<#3B5\>\<#3C2\>
  \<#3B4\>\<#3BF\>\<#3BC\>\<#3AD\>\<#3C2\>
  \<#3B4\>\<#3B5\>\<#3B4\>\<#3BF\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3C9\>\<#3BD\>)
  (\<#39F\>(1)) \<#3BA\>\<#3B1\>\<#3B9\> \<#3BA\>\<#3B1\>\<#3BB\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B7\>\<#3BD\> insert \<#3BC\>\<#3B5\>
  \<#3B1\>\<#3C5\>\<#3C4\>\<#3AC\> \<#3C9\>\<#3C2\>
  \<#3CC\>\<#3C1\>\<#3B9\>\<#3C3\>\<#3BC\>\<#3B1\> (O(log_2(N)),
  \<#3C4\>\<#3BF\> \<#3C0\>\<#3C1\>\<#3B1\>\<#3B3\>\<#3BC\>\<#3B1\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3CC\>
  \<#39D\> \<#3B1\>\<#3BB\>\<#3BB\>\<#3AC\>\<#3B6\>\<#3B5\>\<#3B9\>
  \<#3C3\>\<#3B5\> \<#3BA\>\<#3AC\>\<#3B8\>\<#3B5\>
  \<#3B5\>\<#3C0\>\<#3B1\>\<#3BD\>\<#3AC\>\<#3BB\>\<#3B7\>\<#3C8\>\<#3B7\>
  \<#3B1\>\<#3BB\>\<#3BB\>\<#3AC\> upper bound to \<#39D\>). \<#391\>\<#3BD\>
  \<#3C0\>\<#3C1\>\<#3BF\>\<#3BA\>\<#3CD\>\<#3C8\>\<#3B5\>\<#3B9\>
  \<#3BA\>\<#3AC\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3BF\> Exception \<#3C3\>\<#3B5\>
  \<#3B1\>\<#3C5\>\<#3C4\>\<#3AE\> \<#3C4\>\<#3B7\>\<#3BD\>
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3B4\>\<#3B9\>\<#3BA\>\<#3B1\>\<#3C3\>\<#3AF\>\<#3B1\>,
  \<#3BA\>\<#3AC\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\> throw
  RuntimeException.

  <with|font-series|bold|Time complexity>: O(N*log_2(N))

  <section*|<itemize|<itemize|List searchByLastName(String last_name)>>>

  \<#394\>\<#3B7\>\<#3BC\>\<#3B9\>\<#3BF\>\<#3C5\>\<#3C1\>\<#3B3\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3BC\>\<#3B9\>\<#3B1\> List \<#3B3\>\<#3B9\>\<#3B1\> \<#3BD\>\<#3B1\>
  \<#3B1\>\<#3C0\>\<#3BF\>\<#3B8\>\<#3B7\>\<#3BA\>\<#3B5\>\<#3CD\>\<#3C3\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#3B1\>\<#3C0\>\<#3BF\>\<#3C4\>\<#3AD\>\<#3BB\>\<#3B5\>\<#3C3\>\<#3BC\>\<#3B1\>
  \<#3C4\>\<#3B7\>\<#3C2\> \<#3B1\>\<#3BD\>\<#3B1\>\<#3B6\>\<#3AE\>\<#3C4\>\<#3B7\>\<#3C3\>\<#3B7\>\<#3C2\>
  \<#39F\>(1). \<#397\> \<#3C5\>\<#3BB\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3AE\>\<#3C3\>\<#3B7\>
  \<#3C4\>\<#3B7\>\<#3C2\> List \<#3B5\>\<#3AF\>\<#3BD\>\<#3B1\>\<#3B9\>
  \<#3B2\>\<#3B1\>\<#3C3\>\<#3B9\>\<#3C3\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3B7\>
  \<#3C3\>\<#3C4\>\<#3BF\>\<#3BD\> \<#3C3\>\<#3C7\>\<#3B5\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3CC\>
  \<#3BA\>\<#3CE\>\<#3B4\>\<#3B9\>\<#3BA\>\<#3B1\> \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3B3\>\<#3C1\>\<#3AC\>\<#3C8\>\<#3B1\>\<#3BC\>\<#3B5\>
  \<#3B3\>\<#3B9\>\<#3B1\> \<#3BC\>\<#3B9\>\<#3B1\>
  \<#3C0\>\<#3C1\>\<#3BF\>\<#3B7\>\<#3B3\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>\<#3BD\>\<#3B7\>
  \<#3B5\>\<#3C1\>\<#3B3\>\<#3B1\>\<#3C3\>\<#3AF\>\<#3B1\>
  \<#3C4\>\<#3BF\>\<#3C5\> \<#3BC\>\<#3B1\>\<#3B8\>\<#3AE\>\<#3BC\>\<#3B1\>\<#3C4\>\<#3BF\>\<#3C2\>,
  \<#3BC\>\<#3B5\> \<#3B5\>\<#3BB\>\<#3B1\>\<#3D5\>\<#3C1\>\<#3AD\>\<#3C2\>
  \<#3B1\>\<#3BB\>\<#3BB\>\<#3B1\>\<#3B3\>\<#3AD\>\<#3C2\>. \<#397\>
  \<#3B1\>\<#3BD\>\<#3B1\>\<#3B6\>\<#3AE\>\<#3C4\>\<#3B7\>\<#3C3\>\<#3B7\>
  \<#3B3\>\<#3AF\>\<#3BD\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3B9\> \<#3BC\>\<#3B5\>
  \<#3B1\>\<#3BD\>\<#3B1\>\<#3B4\>\<#3C1\>\<#3BF\>\<#3BC\>\<#3B9\>\<#3BA\>\<#3AD\>\<#3C2\>
  \<#3BA\>\<#3BB\>\<#3AE\>\<#3C3\>\<#3B5\>\<#3B9\>\<#3C2\>
  \<#3C4\>\<#3B7\>\<#3C2\> void traverseAndBuild(TreeNode node, List ls),
  \<#3B7\> \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3B1\>
  \<#3BA\>\<#3AC\>\<#3BD\>\<#3B5\>\<#3B9\> inorder traversal
  \<#3C4\>\<#3BF\>\<#3C5\> BST (\<#39F\>(\<#39D\>)) \<#3BA\>\<#3B1\>\<#3B9\>
  \<#3C0\>\<#3C1\>\<#3BF\>\<#3C3\>\<#3B8\>\<#3AD\>\<#3C4\>\<#3B5\>\<#3B9\>
  \<#3C4\>\<#3BF\>\<#3BD\> \<#3BA\>\<#3CC\>\<#3BC\>\<#3B2\>\<#3BF\>
  \<#3C3\>\<#3C4\>\<#3BF\>\<#3BD\> \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3BF\>
  \<#3B2\>\<#3C1\>\<#3AF\>\<#3C3\>\<#3BA\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3B9\>
  \<#3C3\>\<#3C4\>\<#3B7\>\<#3BD\> List (O(log_2(N))) \<#3B1\>\<#3BD\>
  \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\> \<#3AF\>\<#3B4\>\<#3B9\>\<#3BF\>
  \<#3B5\>\<#3C0\>\<#3CE\>\<#3BD\>\<#3C5\>\<#3BC\>\<#3BF\> \<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#3CC\>\<#3C1\>\<#3B9\>\<#3C3\>\<#3BC\>\<#3B1\> last_name
  (\<#3C4\>\<#3BF\> \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3BF\>
  \<#3B3\>\<#3B9\>\<#3B1\> \<#3B5\>\<#3C5\>\<#3BA\>\<#3BF\>\<#3BB\>\<#3AF\>\<#3B1\>
  \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\> \<#3B1\>\<#3C0\>\<#3BF\>\<#3B8\>\<#3B7\>\<#3BA\>\<#3B5\>\<#3C5\>\<#3C4\>\<#3B5\>\<#3AF\>
  \<#3C3\>\<#3B5\> \<#3AD\>\<#3BD\>\<#3B1\>
  \<#3B5\>\<#3B9\>\<#3B4\>\<#3B9\>\<#3BA\>\<#3CC\>
  \<#3C0\>\<#3B5\>\<#3B4\>\<#3AF\>\<#3BF\> \<#3C4\>\<#3B7\>\<#3C2\> List).
  \<#38C\>\<#3C4\>\<#3B1\>\<#3BD\> \<#3C4\>\<#3B5\>\<#3BB\>\<#3B5\>\<#3B9\>\<#3CE\>\<#3C3\>\<#3B5\>\<#3B9\>
  \<#3B7\> traverseAndBuild, \<#3B5\>\<#3BB\>\<#3AD\>\<#3B3\>\<#3C7\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C0\>\<#3CC\>\<#3C3\>\<#3B1\> \<#3C3\>\<#3C4\>\<#3BF\>\<#3B9\>\<#3C7\>\<#3B5\>\<#3AF\>\<#3B1\>
  \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\> \<#3B7\> ls (\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#3C0\>\<#3B5\>\<#3B4\>\<#3AF\>\<#3BF\>
  \<#3C4\>\<#3B7\>\<#3C2\> N, \<#39F\>(1)) \<#3BA\>\<#3B1\>\<#3B9\>
  \<#3B1\>\<#3BD\> \<#3B5\>\<#3AF\>\<#3BD\>\<#3B1\>\<#3B9\>
  \<#3BC\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3BE\>\<#3CD\> \<#3C4\>\<#3BF\>\<#3C5\> 0
  \<#3BA\>\<#3B1\>\<#3B9\> \<#3C4\>\<#3BF\>\<#3C5\> 5 \<#3C4\>\<#3B1\>
  \<#3B5\>\<#3BA\>\<#3C4\>\<#3C5\>\<#3C0\>\<#3CE\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#39F\>(\<#39D\>_\<#3BB\>\<#3AF\>\<#3C3\>\<#3C4\>\<#3B1\>\<#3C2\>)
  \<#3C0\>\<#3C1\>\<#3B9\>\<#3BD\> \<#3C4\>\<#3B7\>\<#3BD\>
  \<#3B5\>\<#3C0\>\<#3B9\>\<#3C3\>\<#3C4\>\<#3C1\>\<#3AD\>\<#3C8\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>.

  <with|font-series|bold|Time complexity>: O(N*log_2(N))

  <section*|<itemize|<itemize|double getMeanSavings()>>>

  \<#395\>\<#3C0\>\<#3B9\>\<#3C3\>\<#3C4\>\<#3C1\>\<#3AD\>\<#3D5\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> \<#3B1\>\<#3C0\>\<#3BF\>\<#3C4\>\<#3AD\>\<#3BB\>\<#3B5\>\<#3C3\>\<#3BC\>\<#3B1\>
  \<#3C4\>\<#3B7\>\<#3C2\> \<#3BA\>\<#3BB\>\<#3AE\>\<#3C3\>\<#3B7\>\<#3C2\>
  \<#3C4\>\<#3B7\>\<#3C2\> double traverseAndSum(TreeNode node), \<#3B7\>
  \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3B1\> \<#3BC\>\<#3B5\>
  \<#3B1\>\<#3BD\>\<#3B1\>\<#3B4\>\<#3C1\>\<#3BF\>\<#3BC\>\<#3B9\>\<#3BA\>\<#3AD\>\<#3C2\>
  \<#3BA\>\<#3BB\>\<#3AE\>\<#3C3\>\<#3B5\>\<#3B9\>\<#3C2\>
  \<#3BA\>\<#3AC\>\<#3BD\>\<#3B5\>\<#3B9\> inorder traversal (O(N))
  \<#3C4\>\<#3BF\>\<#3C5\> BST (\<#3D5\>\<#3C5\>\<#3C3\>\<#3B9\>\<#3BA\>\<#3AC\>
  \<#3B4\>\<#3B5\>\<#3BD\> \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\>
  \<#3C3\>\<#3B7\>\<#3BC\>\<#3B1\>\<#3C3\>\<#3AF\>\<#3B1\> \<#3B7\>
  \<#3C3\>\<#3B5\>\<#3B9\>\<#3C1\>\<#3AC\>
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3C3\>\<#3C7\>\<#3AF\>\<#3C3\>\<#3B7\>\<#3C2\>)
  \<#3BA\>\<#3B1\>\<#3B9\> \<#3B1\>\<#3B8\>\<#3C1\>\<#3BF\>\<#3AF\>\<#3B6\>\<#3B5\>\<#3B9\>
  \<#3BA\>\<#3B1\>\<#3B9\> \<#3B5\>\<#3C0\>\<#3B9\>\<#3C3\>\<#3C4\>\<#3C1\>\<#3AD\>\<#3D5\>\<#3B5\>\<#3B9\>
  \<#3C4\>\<#3B1\> savings \<#3CC\>\<#3BB\>\<#3C9\>\<#3BD\>
  \<#3C4\>\<#3C9\>\<#3BD\> LargeDepositor \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3C5\>\<#3C0\>\<#3AC\>\<#3C1\>\<#3C7\>\<#3BF\>\<#3C5\>\<#3BD\>
  \<#3C3\>\<#3C4\>\<#3BF\> \<#3B4\>\<#3AD\>\<#3BD\>\<#3C4\>\<#3C1\>\<#3BF\>,
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3B9\>\<#3C1\>\<#3B5\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3BF\>
  \<#3BC\>\<#3B5\> \<#3C4\>\<#3BF\> \<#3C0\>\<#3B5\>\<#3B4\>\<#3AF\>\<#3BF\>
  N \<#3C4\>\<#3BF\>\<#3C5\> BST (O(1)).

  <with|font-series|bold|Time complexity>: O(N)

  <section*|<itemize|<itemize|void print\<Tau\>opLargeDepositors(int k)>>>

  \<#394\>\<#3B7\>\<#3BC\>\<#3B9\>\<#3BF\>\<#3C5\>\<#3C1\>\<#3B3\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3B5\>\<#3BD\>\<#3B1\> priority queue <with|font-series|bold|pq>
  \<#3BC\>\<#3B5\> capacity k (\<#3B7\> \<#3C5\>\<#3BB\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3B7\>\<#3C3\>\<#3B7\>
  \<#3C4\>\<#3B7\>\<#3C2\> \<#3BA\>\<#3BB\>\<#3AC\>\<#3C3\>\<#3B7\>\<#3C2\>
  PQ \<#3B5\>\<#3AF\>\<#3BD\>\<#3B1\>\<#3B9\> \<#3B1\>\<#3C0\>\<#3CC\>
  \<#3C0\>\<#3C1\>\<#3BF\>\<#3B7\>\<#3B3\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>\<#3BD\>\<#3B7\>
  \<#3B5\>\<#3C1\>\<#3B3\>\<#3B1\>\<#3C3\>\<#3AF\>\<#3B1\>, \<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B7\>\<#3BD\> \<#3B4\>\<#3B9\>\<#3B1\>\<#3D5\>\<#3BF\>\<#3C1\>\<#3AC\>
  \<#3CC\>\<#3C4\>\<#3B9\> \<#3BA\>\<#3AC\>\<#3BD\>\<#3B1\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3BF\> capacity \<#3C3\>\<#3C4\>\<#3B1\>\<#3B8\>\<#3B5\>\<#3C1\>\<#3CC\>
  \<#3B3\>\<#3B9\>\<#3B1\> \<#3B4\>\<#3B9\>\<#3B5\>\<#3C5\>\<#3BA\>\<#3BF\>\<#3BB\>\<#3CD\>\<#3BD\>\<#3C3\>\<#3B7\>
  \<#3C3\>\<#3C4\>\<#3B7\>\<#3BD\> \<#3C7\>\<#3C1\>\<#3AE\>\<#3C3\>\<#3B7\>
  \<#3C4\>\<#3B7\>\<#3C2\> \<#3C3\>\<#3B5\> \<#3B1\>\<#3C5\>\<#3C4\>\<#3CC\>
  \<#3C4\>\<#3BF\> \<#3C0\>\<#3BB\>\<#3B1\>\<#3AF\>\<#3C3\>\<#3B9\>\<#3BF\>)
  \<#3BA\>\<#3B1\>\<#3B9\> \<#3BC\>\<#3B9\>\<#3B1\> List
  \<#3C0\>\<#3BF\>\<#3C5\> \<#3B8\>\<#3B1\>
  \<#3C7\>\<#3C1\>\<#3B5\>\<#3B9\>\<#3B1\>\<#3C3\>\<#3C4\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3C3\>\<#3C4\>\<#3B7\>\<#3BD\> \<#3B5\>\<#3BA\>\<#3C4\>\<#3CD\>\<#3C0\>\<#3C9\>\<#3C3\>\<#3B7\>
  \<#3C4\>\<#3C9\>\<#3BD\> \<#3B1\>\<#3C0\>\<#3BF\>\<#3C4\>\<#3B5\>\<#3BB\>\<#3B5\>\<#3C3\>\<#3BC\>\<#3AC\>\<#3C4\>\<#3C9\>\<#3BD\>.

  \<#39A\>\<#3B1\>\<#3BB\>\<#3BF\>\<#3CD\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B7\>\<#3BD\> void traverseAndRank(TreeNode node, PQ pq),
  \<#3B7\> \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3B1\>
  \<#3B1\>\<#3BD\>\<#3B1\>\<#3B4\>\<#3C1\>\<#3BF\>\<#3BC\>\<#3B9\>\<#3BA\>\<#3AC\>
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3C3\>\<#3C7\>\<#3AF\>\<#3B6\>\<#3B5\>\<#3B9\>
  \<#3C4\>\<#3BF\> \<#3B4\>\<#3AD\>\<#3BD\>\<#3C4\>\<#3C1\>\<#3BF\> (O(N),
  \<#3C0\>\<#3AC\>\<#3BB\>\<#3B9\> in-order
  \<#3C7\>\<#3C9\>\<#3C1\>\<#3AF\>\<#3C2\> \<#3BD\>\<#3B1\>
  \<#3BA\>\<#3AC\>\<#3BD\>\<#3B5\>\<#3B9\>
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3D5\>\<#3BF\>\<#3C1\>\<#3AC\> \<#3B7\>
  \<#3C3\>\<#3B5\>\<#3B9\>\<#3C1\>\<#3AC\>) \<#3BA\>\<#3B1\>\<#3B9\>
  \<#3C0\>\<#3C1\>\<#3BF\>\<#3C3\>\<#3B8\>\<#3AD\>\<#3C4\>\<#3B5\>\<#3B9\>
  (O(log_2(N))) \<#3C4\>\<#3BF\> LargeDepositor \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3B5\>\<#3AF\>\<#3BD\>\<#3B1\>\<#3B9\>
  \<#3B1\>\<#3C0\>\<#3BF\>\<#3B8\>\<#3B7\>\<#3BA\>\<#3B5\>\<#3C5\>\<#3BC\>\<#3AD\>\<#3BD\>\<#3BF\>
  \<#3C3\>\<#3C4\>\<#3BF\> TreeNode \<#3C0\>\<#3BF\>\<#3C5\>
  \<#3B2\>\<#3C1\>\<#3AF\>\<#3C3\>\<#3BA\>\<#3B5\>\<#3C4\>\<#3B1\>\<#3B9\>
  \<#3C3\>\<#3B5\> \<#3BA\>\<#3AC\>\<#3B8\>\<#3B5\>
  \<#3BA\>\<#3BB\>\<#3AE\>\<#3C3\>\<#3B7\> \<#3C4\>\<#3B7\>\<#3C2\>,
  \<#3B5\>\<#3D5\>\<#3CC\>\<#3C3\>\<#3BF\>\<#3BD\> \<#3B7\> pq
  \<#3B4\>\<#3B5\>\<#3BD\> \<#3AD\>\<#3C7\>\<#3B5\>\<#3B9\>
  \<#3B3\>\<#3B5\>\<#3BC\>\<#3AF\>\<#3C3\>\<#3B5\>\<#3B9\>, \<#3AE\>
  \<#3B4\>\<#3B9\>\<#3B1\>\<#3D5\>\<#3BF\>\<#3C1\>\<#3B5\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3AC\>
  \<#3B5\>\<#3AC\>\<#3BD\> \<#3C4\>\<#3BF\> score \<#3C4\>\<#3BF\>\<#3C5\>
  \<#3C4\>\<#3C1\>\<#3AD\>\<#3C7\>\<#3BF\>\<#3BD\>\<#3C4\>\<#3BF\>\<#3C2\>
  LargeDepositor \<#3B5\>\<#3AF\>\<#3BD\>\<#3B1\>\<#3B9\>
  \<#3C5\>\<#3C8\>\<#3B7\>\<#3BB\>\<#3CC\>\<#3C4\>\<#3B5\>\<#3C1\>\<#3BF\>
  \<#3B1\>\<#3C0\>\<#3CC\> \<#3C4\>\<#3BF\> score \<#3C4\>\<#3BF\>\<#3C5\>
  min \<#3C4\>\<#3B7\>\<#3C2\> pq (\<#3BF\> comparator
  \<#3C4\>\<#3B7\>\<#3C2\> \<#3C4\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B8\>\<#3B5\>\<#3C4\>\<#3B5\>\<#3AF\>
  \<#3C3\>\<#3B5\> \<#3B1\>\<#3C5\>\<#3C4\>\<#3AE\> \<#3C4\>\<#3B7\>\<#3BD\>
  \<#3B8\>\<#3AD\>\<#3C3\>\<#3B7\> \<#3C4\>\<#3BF\> LargeDepositor
  \<#3BC\>\<#3B5\> \<#3C4\>\<#3BF\> \<#3BC\>\<#3B9\>\<#3BA\>\<#3C1\>\<#3CC\>\<#3C4\>\<#3B5\>\<#3C1\>\<#3BF\>
  score \<#3B1\>\<#3C0\>\<#3CC\> \<#3B1\>\<#3C5\>\<#3C4\>\<#3AC\>
  \<#3C4\>\<#3B7\>\<#3C2\> pq), \<#3C3\>\<#3C4\>\<#3B7\>\<#3BD\>
  \<#3BF\>\<#3C0\>\<#3BF\>\<#3AF\>\<#3B1\>
  \<#3C0\>\<#3B5\>\<#3C1\>\<#3AF\>\<#3C0\>\<#3C4\>\<#3C9\>\<#3C3\>\<#3B7\>
  \<#3C0\>\<#3C1\>\<#3CE\>\<#3C4\>\<#3B1\>
  \<#3B1\>\<#3D5\>\<#3B1\>\<#3B9\>\<#3C1\>\<#3B5\>\<#3AF\> \<#3C4\>\<#3BF\>
  \<#3B5\>\<#3BB\>\<#3AC\>\<#3C7\>\<#3B9\>\<#3C3\>\<#3C4\>\<#3BF\>
  \<#3C3\>\<#3C4\>\<#3BF\>\<#3B9\>\<#3C7\>\<#3B5\>\<#3AF\>\<#3BF\>
  \<#3B1\>\<#3C0\>\<#3CC\> \<#3C4\>\<#3B7\>\<#3BD\> pq (O(log_2(N)))
  \<#3CE\>\<#3C3\>\<#3C4\>\<#3B5\> \<#3BD\>\<#3B1\>
  \<#3B1\>\<#3C0\>\<#3BF\>\<#3D5\>\<#3B5\>\<#3C5\>\<#3C7\>\<#3B8\>\<#3B5\>\<#3AF\>
  \<#3C4\>\<#3BF\> overflow \<#3C4\>\<#3B7\>\<#3C2\>.

  \<#39C\>\<#3BF\>\<#3BB\>\<#3AF\>\<#3C2\>
  \<#3C4\>\<#3B5\>\<#3BB\>\<#3B5\>\<#3B9\>\<#3CE\>\<#3C3\>\<#3B5\>\<#3B9\>
  \<#3B7\> traverseAndRank, \<#3BC\>\<#3B5\> \<#3AD\>\<#3BD\>\<#3B1\> loop
  O(N) \<#3B1\>\<#3C0\>\<#3BF\>\<#3B8\>\<#3B7\>\<#3BA\>\<#3B5\>\<#3CD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  \<#3C4\>\<#3B1\> LargeDepositor \<#3C4\>\<#3BF\>\<#3C5\> pq
  \<#3C3\>\<#3C4\>\<#3B7\>\<#3BD\> List, \<#3C7\>\<#3C1\>\<#3B7\>\<#3C3\>\<#3B9\>\<#3BC\>\<#3BF\>\<#3C0\>\<#3BF\>\<#3B9\>\<#3CC\>\<#3BD\>\<#3C4\>\<#3B1\>\<#3C2\>
  \<#3C4\>\<#3B7\>\<#3BD\> \<#3BF\>\<#3C5\>\<#3C3\>\<#3B9\>\<#3B1\>\<#3C3\>\<#3C4\>\<#3B9\>\<#3BA\>\<#3AC\>
  \<#3C3\>\<#3B1\>\<#3BD\> \<#3AD\>\<#3BD\>\<#3B1\> stack,
  \<#3B1\>\<#3D5\>\<#3BF\>\<#3CD\> \<#3BA\>\<#3AC\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  insertAtFront \<#3C4\>\<#3B1\> \<#3C3\>\<#3C4\>\<#3BF\>\<#3B9\>\<#3C7\>\<#3B5\>\<#3AF\>\<#3B1\>
  \<#3BC\>\<#3B5\> \<#3B1\>\<#3CD\>\<#3BE\>\<#3BF\>\<#3C5\>\<#3C3\>\<#3B1\>
  \<#3C3\>\<#3B5\>\<#3B9\>\<#3C1\>\<#3AC\> \<#3BA\>\<#3B1\>\<#3C4\>\<#3AC\>
  score, \<#3BA\>\<#3B1\>\<#3B9\> \<#3BC\>\<#3AD\>\<#3C4\>\<#3B1\>
  \<#3C4\>\<#3B1\> \<#3BA\>\<#3AC\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3BC\>\<#3B5\>
  removeFromFront \<#3BC\>\<#3B5\> \<#3D5\>\<#3B8\>\<#3AF\>\<#3BD\>\<#3BF\>\<#3C5\>\<#3C3\>\<#3B1\>
  \<#3C3\>\<#3B5\>\<#3B9\>\<#3C1\>\<#3AC\>,
  \<#3C0\>\<#3B1\>\<#3C1\>\<#3AC\>\<#3BB\>\<#3BB\>\<#3B7\>\<#3BB\>\<#3B1\>
  \<#3B5\>\<#3BA\>\<#3C4\>\<#3C5\>\<#3C0\>\<#3CE\>\<#3BD\>\<#3BF\>\<#3BD\>\<#3C4\>\<#3B1\>\<#3C2\>
  \<#3C4\>\<#3B1\>.

  <with|font-series|bold|Time complexity>: O(N*log_2(N))

  <section*|void updateSavings(int AFM, double savings)>

  \<Alpha\>\<nu\>\<alpha\>\<zeta\>\<eta\>\<tau\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<tau\>\<omicron\>\<nu\> LargeDepositor \<mu\>\<varepsilon\>
  \<tau\>\<omicron\> \<delta\>\<omicron\>\<sigma\>\<mu\>\<#3AD\>\<nu\>\<omicron\>
  \<Alpha\>\<Phi\>\<Mu\> \<mu\>\<#3AD\>\<sigma\>\<alpha\>
  \<alpha\>\<pi\>\<#3CC\> \<tau\>\<eta\>\<nu\>
  \<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\> foundByAFM(int AFM),
  \<eta\> \<omicron\>\<pi\>\<omicron\>\<#3AF\>\<alpha\>
  \<varepsilon\>\<kappa\>\<tau\>\<varepsilon\>\<lambda\>\<varepsilon\>\<#3AF\>
  \<delta\>\<upsilon\>\<alpha\>\<delta\>\<iota\>\<kappa\>\<#3AE\>
  \<alpha\>\<nu\>\<alpha\>\<zeta\>\<#3AE\>\<tau\>\<eta\>\<sigma\>\<eta\>
  \<mu\>\<varepsilon\> \<kappa\>\<lambda\>\<varepsilon\>\<iota\>\<delta\>\<#3AF\>
  \<tau\>\<omicron\> \<Alpha\>\<Phi\>\<Mu\>. \<Alpha\>\<nu\>
  \<tau\>\<omicron\>\<nu\> \<beta\>\<rho\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<varepsilon\>\<nu\>\<eta\>\<mu\>\<varepsilon\>\<rho\>\<#3CE\>\<nu\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<tau\>\<omicron\> \<pi\>\<varepsilon\>\<delta\>\<#3AF\>\<omicron\> savings
  \<alpha\>\<lambda\>\<lambda\>\<iota\>\<#3CE\>\<varsigma\>
  \<varepsilon\>\<kappa\>\<tau\>\<upsilon\>\<pi\>\<#3CE\>\<nu\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<alpha\>\<nu\>\<#3AC\>\<lambda\>\<omicron\>\<gamma\>\<omicron\>
  \<mu\>\<#3AE\>\<nu\>\<upsilon\>\<mu\>\<alpha\>.

  \<Sigma\>\<varepsilon\> \<kappa\>\<#3AC\>\<theta\>\<varepsilon\>
  \<pi\>\<varepsilon\>\<rho\>\<#3AF\>\<pi\>\<tau\>\<omega\>\<sigma\>\<eta\>
  \<lambda\>\<#3CC\>\<gamma\>\<omega\> \<tau\>\<eta\>\<varsigma\>
  \<delta\>\<upsilon\>\<alpha\>\<delta\>\<iota\>\<kappa\>\<#3AE\>\<varsigma\>
  \<alpha\>\<nu\>\<alpha\>\<zeta\>\<#3AE\>\<tau\>\<eta\>\<sigma\>\<eta\>\<varsigma\>
  \<eta\> \<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\>\<varsigma\>
  \<#3AD\>\<chi\>\<varepsilon\>\<iota\> <with|font-series|bold|Time
  Complexity> -\<gtr\> O(logn), \<#3CC\>\<pi\>\<omicron\>\<upsilon\> n
  \<omicron\> \<alpha\>\<rho\>\<iota\>\<theta\>\<mu\>\<#3CC\>\<varsigma\>
  \<kappa\>\<#3CC\>\<mu\>\<beta\>\<omega\>\<nu\>
  \<tau\>\<omicron\>\<upsilon\> \<delta\>\<#3AD\>\<nu\>\<tau\>\<rho\>\<omicron\>\<upsilon\>.

  <section*|<itemize|<itemize|LargeDepositor searchByAFM(int AFM)>>>

  \<Alpha\>\<nu\>\<alpha\>\<zeta\>\<eta\>\<tau\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<tau\>\<omicron\>\<nu\> LargeDepositor \<mu\>\<varepsilon\>
  \<tau\>\<omicron\> \<delta\>\<omicron\>\<sigma\>\<mu\>\<#3AD\>\<nu\>\<omicron\>
  \<Alpha\>\<Phi\>\<Mu\> \<mu\>\<#3AD\>\<sigma\>\<alpha\>
  \<alpha\>\<pi\>\<#3CC\> \<tau\>\<eta\>\<nu\>\n\<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\>
  foundByAFM(int AFM), \<eta\> \<omicron\>\<pi\>\<omicron\>\<#3AF\>\<alpha\>
  \<varepsilon\>\<kappa\>\<tau\>\<varepsilon\>\<lambda\>\<varepsilon\>\<#3AF\>
  \<delta\>\<upsilon\>\<alpha\>\<delta\>\<iota\>\<kappa\>\<#3AE\>
  \<alpha\>\<nu\>\<alpha\>\<zeta\>\<#3AE\>\<tau\>\<eta\>\<sigma\>\<eta\>
  \<mu\>\<varepsilon\> \<kappa\>\<lambda\>\<varepsilon\>\<iota\>\<delta\>\<#3AF\>
  \<tau\>\<omicron\> \<Alpha\>\<Phi\>\<Mu\>. \<Alpha\>\<nu\>
  \<tau\>\<omicron\>\<nu\> \<beta\>\<rho\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<tau\>\<omicron\>\<nu\> \<varepsilon\>\<pi\>\<iota\>\<sigma\>\<tau\>\<rho\>\<#3AD\>\<varphi\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<alpha\>\<lambda\>\<lambda\>\<iota\>\<#3CE\>\<varsigma\>
  \<varepsilon\>\<kappa\>\<tau\>\<upsilon\>\<pi\>\<#3CE\>\<nu\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<alpha\>\<nu\>\<#3AC\>\<lambda\>\<omicron\>\<gamma\>\<omicron\>
  \<mu\>\<#3AE\>\<nu\>\<upsilon\>\<mu\>\<alpha\> \<kappa\>\<alpha\>\<iota\>
  \<varepsilon\>\<pi\>\<iota\>\<sigma\>\<tau\>\<rho\>\<#3AD\>\<varphi\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  null.

  \<Sigma\>\<varepsilon\> \<kappa\>\<#3AC\>\<theta\>\<varepsilon\>
  \<pi\>\<varepsilon\>\<rho\>\<#3AF\>\<pi\>\<tau\>\<omega\>\<sigma\>\<eta\>
  \<lambda\>\<#3CC\>\<gamma\>\<omega\> \<tau\>\<eta\>\<varsigma\>
  \<delta\>\<upsilon\>\<alpha\>\<delta\>\<iota\>\<kappa\>\<#3AE\>\<varsigma\>
  \<alpha\>\<nu\>\<alpha\>\<zeta\>\<#3AE\>\<tau\>\<eta\>\<sigma\>\<eta\>\<varsigma\>
  \<eta\> \<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\>\<varsigma\>
  \<#3AD\>\<chi\>\<varepsilon\>\<iota\> <with|font-series|bold|Time
  Complexity>-\<gtr\> O(logn), \<#3CC\>\<pi\>\<omicron\>\<upsilon\> n
  \<omicron\> \<alpha\>\<rho\>\<iota\>\<theta\>\<mu\>\<#3CC\>\<varsigma\>
  \<kappa\>\<#3CC\>\<mu\>\<beta\>\<omega\>\<nu\>
  \<tau\>\<omicron\>\<upsilon\> \<delta\>\<#3AD\>\<nu\>\<tau\>\<rho\>\<omicron\>\<upsilon\>

  <section*|void remove(int AFM)>

  \<Alpha\>\<nu\>\<alpha\>\<zeta\>\<eta\>\<tau\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<tau\>\<omicron\>\<nu\> LargeDepositor \<mu\>\<varepsilon\>
  \<tau\>\<omicron\> \<delta\>\<omicron\>\<sigma\>\<mu\>\<#3AD\>\<nu\>\<omicron\>
  \<Alpha\>\<Phi\>\<Mu\> \<mu\>\<#3AD\>\<sigma\>\<alpha\>
  \<alpha\>\<pi\>\<#3CC\> \<tau\>\<eta\>\<nu\>
  \<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\> foundByAFM(int AFM).
  \<Alpha\>\<nu\> \<delta\>\<varepsilon\>\<nu\> \<tau\>\<omicron\>\<nu\>
  \<beta\>\<rho\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>,
  \<delta\>\<varepsilon\>\<nu\> \<gamma\>\<#3AF\>\<nu\>\<varepsilon\>\<tau\>\<alpha\>\<iota\>
  \<tau\>\<#3AF\>\<pi\>\<omicron\>\<tau\>\<alpha\>. \<Alpha\>\<nu\>
  \<#3CC\>\<mu\>\<omega\>\<varsigma\> \<tau\>\<omicron\>\<nu\>
  \<beta\>\<rho\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>,
  \<tau\>\<#3CC\>\<tau\>\<varepsilon\> \<theta\>\<alpha\>
  \<pi\>\<rho\>\<#3AD\>\<pi\>\<varepsilon\>\<iota\> \<nu\>\<alpha\>
  \<pi\>\<#3AC\>\<rho\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<mu\>\<iota\>\<alpha\> \<tau\>\<upsilon\>\<chi\>\<alpha\>\<#3AF\>\<alpha\>
  \<alpha\>\<pi\>\<#3CC\>\<varphi\>\<alpha\>\<sigma\>\<eta\>
  \<gamma\>\<iota\>\<alpha\> \<tau\>\<omicron\>
  \<pi\>\<omicron\>\<iota\>\<omicron\> \<alpha\>\<pi\>\<#3CC\>
  \<tau\>\<alpha\> \<pi\>\<alpha\>\<iota\>\<delta\>\<iota\>\<#3AC\>
  \<tau\>\<omicron\>\<upsilon\> \<theta\>\<alpha\>
  \<mu\>\<pi\>\<varepsilon\>\<iota\> \<sigma\>\<tau\>\<eta\>\<nu\>
  \<theta\>\<#3AD\>\<sigma\>\<eta\> \<tau\>\<omicron\>\<upsilon\>.
  \<Gamma\>\<iota\>\<alpha\> \<tau\>\<eta\>\<nu\>
  \<delta\>\<iota\>\<alpha\>\<delta\>\<iota\>\<kappa\>\<alpha\>\<sigma\>\<#3AF\>\<alpha\>
  \<tau\>\<eta\>\<varsigma\> \<#3AD\>\<nu\>\<omega\>\<sigma\>\<eta\>\<varsigma\>
  \<chi\>\<rho\>\<eta\>\<sigma\>\<iota\>\<mu\>\<omicron\>\<pi\>\<omicron\>\<iota\>\<omicron\>\<#3CD\>\<mu\>\<varepsilon\>
  \<tau\>\<eta\>\<nu\> \<mu\>\<#3AD\>\<theta\>\<omicron\>\<delta\>\<omicron\>
  TreeNode joinNode(TreeNode a, TreeNode b), \<varepsilon\>\<nu\>\<#3CE\>
  \<eta\> \<tau\>\<alpha\>\<chi\>\<#3CD\>\<tau\>\<eta\>\<tau\>\<alpha\>
  \<tau\>\<eta\>\<varsigma\> \<mu\>\<varepsilon\>\<theta\>\<#3CC\>\<delta\>\<omicron\>\<upsilon\>
  \<varepsilon\>\<xi\>\<alpha\>\<rho\>\<tau\>\<#3AC\>\<tau\>\<alpha\>\<iota\>
  \<alpha\>\<pi\>\<#3CC\> \<tau\>\<omicron\>
  \<#3CD\>\<psi\>\<omicron\>\<varsigma\>\n\<tau\>\<omicron\>\<upsilon\>
  \<delta\>\<#3AD\>\<nu\>\<tau\>\<rho\>\<omicron\>\<upsilon\>
  \<kappa\>\<alpha\>\<iota\> \<#3AC\>\<rho\>\<alpha\>
  \<alpha\>\<varphi\>\<omicron\>\<#3CD\> \<#3AD\>\<chi\>\<omicron\>\<upsilon\>\<mu\>\<varepsilon\>
  \<Tau\>\<upsilon\>\<chi\>\<alpha\>\<iota\>\<omicron\>\<pi\>\<omicron\>\<iota\>\<eta\>\<mu\>\<#3AD\>\<nu\>\<omicron\>
  \<Delta\>\<Delta\>\<Alpha\> (\<#3AC\>\<rho\>\<alpha\>
  \<iota\>\<sigma\>\<omicron\>\<zeta\>\<upsilon\>\<gamma\>\<iota\>\<sigma\>\<mu\>\<#3AD\>\<nu\>\<omicron\>
  \<delta\>\<#3AD\>\<nu\>\<tau\>\<rho\>\<omicron\>) \<tau\>\<omicron\>
  \<#3CD\>\<psi\>\<omicron\>\<varsigma\> \<theta\>\<alpha\>
  \<varepsilon\>\<#3AF\>\<nu\>\<alpha\>\<iota\>
  \<pi\>\<varepsilon\>\<rho\>\<#3AF\>\<pi\>\<omicron\>\<upsilon\> logn.

  <with|font-series|bold|Time Complexity> -\<gtr\> O(logn)
</body>

<\initial>
  <\collection>
    <associate|font|frak=TeX Gyre Pagella,cal=TeX Gyre Termes,Helvetica Neue>
    <associate|font-base-size|10>
    <associate|math-font|math-schola>
    <associate|page-medium|paper>
  </collection>
</initial>

<\references>
  <\collection>
    <associate|auto-1|<tuple|?|1>>
    <associate|auto-2|<tuple|?|1>>
    <associate|auto-3|<tuple|?|1>>
    <associate|auto-4|<tuple|?|1>>
    <associate|auto-5|<tuple|?|2>>
    <associate|auto-6|<tuple|?|2>>
    <associate|auto-7|<tuple|?|2>>
    <associate|auto-8|<tuple|?|2>>
  </collection>
</references>

<\auxiliary>
  <\collection>
    <\associate|toc>
      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <surround|<no-page-break*>|<no-indent*>|void
                insert(LargeDepositor item)>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-1><vspace|0.5fn>

      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <\surround|<no-page-break*>|<no-indent*>>
                  <\with|itemize-level|<quote|2>>
                    <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
                    \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
                    <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
                    <\with|par-left|<quote|<tmlen|64000.2|128000|192000>>>
                    <surround|<no-page-break*>|<no-indent*>|void load(String
                    filename)>
                    </with>
                    </surround>
                    </with>
                  </with>
                </surround>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-2><vspace|0.5fn>

      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <\surround|<no-page-break*>|<no-indent*>>
                  <\with|itemize-level|<quote|2>>
                    <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
                    \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
                    <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
                    <\with|par-left|<quote|<tmlen|64000.2|128000|192000>>>
                    <surround|<no-page-break*>|<no-indent*>|List
                    searchByLastName(String last_name)>
                    </with>
                    </surround>
                    </with>
                  </with>
                </surround>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-3><vspace|0.5fn>

      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <\surround|<no-page-break*>|<no-indent*>>
                  <\with|itemize-level|<quote|2>>
                    <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
                    \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
                    <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
                    <\with|par-left|<quote|<tmlen|64000.2|128000|192000>>>
                    <surround|<no-page-break*>|<no-indent*>|double
                    getMeanSavings()>
                    </with>
                    </surround>
                    </with>
                  </with>
                </surround>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-4><vspace|0.5fn>

      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <\surround|<no-page-break*>|<no-indent*>>
                  <\with|itemize-level|<quote|2>>
                    <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
                    \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
                    <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
                    <\with|par-left|<quote|<tmlen|64000.2|128000|192000>>>
                    <surround|<no-page-break*>|<no-indent*>|void
                    print\<Tau\>opLargeDepositors(int k)>
                    </with>
                    </surround>
                    </with>
                  </with>
                </surround>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-5><vspace|0.5fn>

      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|void
      updateSavings(int AFM, double savings)>
      <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-6><vspace|0.5fn>

      <vspace*|1fn><\with|font-series|<quote|bold>|math-font-series|<quote|bold>>
        <\with|itemize-level|<quote|1>>
          <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
          \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
            <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
              <\with|par-left|<quote|<tmlen|32000.1|63999.9|96000>>>
                <\surround|<no-page-break*>|<no-indent*>>
                  <\with|itemize-level|<quote|2>>
                    <\with|current-item|<quote|<macro|name|<aligned-item|<arg|name>
                    \ >>>|transform-item|<quote|<macro|name|<item-tag>>>|item-nr|<quote|0>>
                    <\surround|<vspace*|0.5fn><no-indent>|<specific|texmacs|<htab|0fn|first>><vspace|0.5fn>>
                    <\with|par-left|<quote|<tmlen|64000.2|128000|192000>>>
                    <surround|<no-page-break*>|<no-indent*>|LargeDepositor
                    searchByAFM(int AFM)>
                    </with>
                    </surround>
                    </with>
                  </with>
                </surround>
              </with>
            </surround>
          </with>
        </with>
      </with> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-7><vspace|0.5fn>

      <vspace*|1fn><with|font-series|<quote|bold>|math-font-series|<quote|bold>|void
      remove(int AFM)> <datoms|<macro|x|<repeat|<arg|x>|<with|font-series|medium|<with|font-size|1|<space|0.2fn>.<space|0.2fn>>>>>|<htab|5mm>>
      <no-break><pageref|auto-8><vspace|0.5fn>
    </associate>
  </collection>
</auxiliary>