package net.mightypork.rpw.tree.assets.processors;

import net.mightypork.rpw.library.MagicSources;
import net.mightypork.rpw.tree.assets.tree.AssetTreeGroup;
import net.mightypork.rpw.tree.assets.tree.AssetTreeLeaf;
import net.mightypork.rpw.tree.assets.tree.AssetTreeNode;
import net.mightypork.rpw.tree.assets.tree.AssetTreeProcessor;

import java.util.HashSet;
import java.util.Set;


public class SetToSourceProcessor implements AssetTreeProcessor {

    private String source;

    private final Set<AssetTreeNode> processed = new HashSet<AssetTreeNode>();

    private boolean modifyLeaves = true;


    public void setModifyLeaves(boolean modifyLeaves) {
        this.modifyLeaves = modifyLeaves;
    }


    public void setSource(String source) {
        this.source = source;
    }


    public SetToSourceProcessor(String source) {
        this.source = source;
    }


    @Override
    public void process(AssetTreeNode node) {
        if (processed.contains(node)) return; // no double-processing
        processed.add(node);

        if (node instanceof AssetTreeGroup) {
            final AssetTreeGroup group = (AssetTreeGroup) node;
            group.setLibrarySource(source);

        } else if (node instanceof AssetTreeLeaf) {
            if (!modifyLeaves) return;

            final AssetTreeLeaf leaf = (AssetTreeLeaf) node;

            if (MagicSources.isSilence(source)) {
                if (!leaf.getAssetType().isSound()) return;
            }

            leaf.setLibrarySource(source);

        }
    }

}
