package br.com.fiap.cetesb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PraiaAdapter(private val praias: MutableList<Praia>, private val onExcluirClick: (Praia) -> Unit) : RecyclerView.Adapter<PraiaAdapter.PraiaViewHolder>() {

    inner class PraiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomePraia: TextView = itemView.findViewById(R.id.textViewNomePraia)
        val cidade: TextView = itemView.findViewById(R.id.textViewCidade)
        val estado: TextView = itemView.findViewById(R.id.textViewEstado)
        val buttonExcluir: Button = itemView.findViewById(R.id.buttonExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PraiaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_praia, parent, false)
        return PraiaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PraiaViewHolder, position: Int) {
        val praia = praias[position]
        holder.nomePraia.text = praia.nome
        holder.cidade.text = praia.cidade
        holder.estado.text = praia.estado

        holder.buttonExcluir.setOnClickListener {
            onExcluirClick(praia)
        }
    }

    override fun getItemCount(): Int = praias.size
}