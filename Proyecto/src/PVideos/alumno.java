package PVideos;

public class alumno {
	private String id, titulo, autor, categoria, rese�a;

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
	public String getRese�a() {
		return rese�a;
	}

	public void setRese�a(String rese�a) {
		this.rese�a = rese�a;
	}
	@Override
	public String toString() {
		return "Libro [id:" + id + ", titulo:" + titulo + ", autor:" + autor + ", categoria:"+ categoria+ ", rese�a:"+ rese�a +"]";
	}	
	
}
