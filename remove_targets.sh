#!/usr/bin/env zsh

# Check if parent directory is provided
if [[ $# -eq 0 ]]; then
    echo "Usage: $0 <parent_directory>"
    exit 1
fi

parent_dir="$1"

# Check if the parent directory exists
if [[ ! -d "$parent_dir" ]]; then
    echo "Error: Directory '$parent_dir' does not exist"
    exit 1
fi

# Traverse immediate subdirectories
for subdir in "$parent_dir"/*(N/); do
    target_dir="$subdir/target"
    
    if [[ -d "$target_dir" ]]; then
        echo "Removing: $target_dir"
        rm -rf "$target_dir"
    fi
done

echo "Done!"
