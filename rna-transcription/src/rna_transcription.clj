(ns rna-transcription)

(def dna->rna {"G" "C"
               "C" "G"
               "T" "A"
               "A" "U"})

(def dna->rna-char {\G \C
                    \C \G
                    \T \A
                    \A \U})

(defn to-rna
  "Returns the RNA complement of the given DNA string sequence."
  [dna]
  (->> (seq dna)
       (map char)
       (map (comp dna->rna str))
       (apply str)))

(defn to-rna
  [dna]
  (apply str (map dna->rna-char dna)))
