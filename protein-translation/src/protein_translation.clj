(ns protein-translation)


(defn codon->amino-acid
  [codon]
  (condp some [codon]
    #{"AUG"} "Methionine"
    #{"UUU" "UUC"} "Phenylalanine"
    #{"UUA" "UUG"} "Leucine"
    #{"UCU" "UCC" "UCA" "UCG"} "Serine"
    #{"UAU" "UAC"} "Tyrosine"
    #{"UGU" "UGC"} "Cysteine"
    #{"UGG"} "Tryptophan"
    #{"UAA" "UAG" "UGA"} "STOP"
    nil))

(defn translate-rna
  " Translates an RNA string into amino acids. "
  [rna]
  (let [rna-items (partition 3 rna)]
    (loop [remaining rna-items
           acids []]
      (if-let [item (codon->amino-acid (apply str (first remaining)))]
        (if (= "STOP" item)
          acids
          (recur (rest remaining) (conj acids item)))
        acids))))


(defn translate-rna [rna]
  (->> (map #(apply str %) (partition-all 3 rna))
       (map (fn [codon]
              (let [amino-acid (codon->amino-acid codon)]
                (cond
                  (nil? amino-acid) (throw (IllegalArgumentException. "Invalid codon"))
                  (= amino-acid "STOP") ::stop
                  :else amino-acid))))
       (take-while #(not= % ::stop))
       (into [])))