package PVideos;

public class alumno {
	private String id, titulo, autor, categoria, reseña;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getReseña() {
		return reseña;
	}

	public void setReseña(String reseña) {
		this.reseña = reseña;
	}
	@Override
	public String toString() {
		return "Libro [id:" + id + ", titulo:" + titulo + ", autor:" + autor + ", categoria:"+ categoria+ ", reseña:"+ reseña +"]";
	}	
	
}
