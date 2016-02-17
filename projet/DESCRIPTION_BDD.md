<h2> La base de données </h2>

<h4> Les Tables </h4>
  <p>
    Après une bonne lecture du cahier des charges fonctionnel et suite à bonne analyse, 
    nous nous sommes décidés d'attribuer 5 tables à notre base de données.
    <ul>
      <li> Salle : </li> <span> qui contient les noms de salles </span>
      <li> Etagere : </li> <span> qui contient les numéros des étagères </span>
      <li> Discipline : </li> <span> permet de stocker les noms des différentes disciplines </span>
      <li> SousDiscipline : </li> <span> contient les sous-disciplines </span>
      <li> Cote : </li> <span> Il faut savoir que chaque cote a une racine. Raison pour laquelle nous avons créé un attribut "racine" dans cette table, qui définit quelle est la racine de la cote concernée </span>
    </ul>
  </p>  
  
    
<h4> Dépendances </h4>
<p>
        <ul>
          <li> Une salle contient au moins une étagère, mais aussi peut en contenir plusieurs. Tandis q'une étagère définie ne peut être que dans une seule salle </li>
          <li> Une salle a plusieurs discipline dans son enceinte, mais une disciplline ne peut se trouver que dans une salle </li>
          <li> La discipline quant à elle, a plusieurs sous-discipline mais une sous-discipline reste spécifique qu'à une seule discipline </li>
          <li> La discipline toujours, peut correspondre à plusieurs racine de cote mais une racine de cote ne peut concernée qu'une discipline bien déterminée. </li>
          </ul>
</p>          
 
