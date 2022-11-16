#include <iostream>
#include <bits/stdc++.h>
using namespace std;

struct minHeapNode
{
    char data;
    unsigned freq;

    minHeapNode *left, *right;
    minHeapNode(char data, unsigned freq)
    {
        this->data = data;
        this->freq = freq;
        this->left = this->right = NULL;
    }
};

struct compare
{

    bool operator()(minHeapNode *l, minHeapNode *r)
    {
        return l->freq > r->freq;
    }
};

void printHuffman(minHeapNode *root, string op)
{
    if (!root)
    {
        return;
    }

    if (root->data != '$')
    {
        cout << root->data << ":" << op << endl;
    }
    else
    {
        printHuffman(root->left, op + '0');
        printHuffman(root->right, op + '1');
    }
}

void huffmanCodes(char data[], int freq[], int size)
{
    minHeapNode *left, *right, *top;

    priority_queue<minHeapNode *, vector<minHeapNode *>, compare> min_pq;

    for (int i = 0; i < size; i++)
    {
        min_pq.push(new minHeapNode(data[i], freq[i]));
    }

    while (min_pq.size() != 1)
    {
        left = min_pq.top();
        min_pq.pop();
        right = min_pq.top();
        min_pq.pop();

        top = new minHeapNode('$', left->freq + right->freq);
        top->left = left;
        top->right = right;
        min_pq.push(top);
    }
    printHuffman(min_pq.top(), "");
}

int main(int argc, char const *argv[])
{
    char arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};
    int freq[] = {5, 9, 12, 13, 16, 45};

    int size = sizeof(arr) / sizeof(arr[0]);

    huffmanCodes(arr, freq, size);

    return 0;
}
