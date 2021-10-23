class Solution {
public:
    int maxDia=-1;
    
    int height(TreeNode*root)
    {
        if(root==nullptr)
            return -1;
        int lh=height(root->left);
        int rh=height(root->right);
        maxDia=max(maxDia,lh+rh+2);
        return max(lh,rh)+1;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        height(root);
        return maxDia;
    }
};