import { defineConfig } from 'vite'

export default defineConfig({
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/user': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/psychological-chat': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/knowledge': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/file': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/emotion-diary': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      },
      '/data-analytics': {
        target: 'http://localhost:1236',
        changeOrigin: true,
      }
    }
  }
})